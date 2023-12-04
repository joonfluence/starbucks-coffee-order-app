package com.joonfluence.starbucks.domain.user.auth.service;

import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.global.security.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {
    @Mock
    JwtService jwtService;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    Authentication authentication;
    @InjectMocks
    AuthenticationService authenticationService;

    private RegisterRequest registerRequestDto;
    private RegisterRequest blankRegisterRequestDto;
    private Customer user;
    private LoginRequest loginRequest;
    private AuthenticationResponse response;


    @BeforeEach
    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
        blankRegisterRequestDto = RegisterRequest.builder().email("").name("Joonho").password("12341234").build();
        user = registerRequestDto.toEntity();
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("12341234").passwordRepeated("12341234").build();
        response = AuthenticationResponse.builder().accessToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAxNjg4NjA0fQ.VlSs4U8ferPP8Uh5QmumVmeO_OgRMwk8YK7_lSOAY5kFY3Hos1u14FvQNQQ3b_spTLSpsZOYOx7Rx5tgBL-95Q").refreshToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAyMjkxNjA0fQ.G5xYWiC8xN5vhZtT_QQ_wEk8_y0SAsmODF2oqLC7KS-JEjvKPYKYIiv6GUf4b1tlfT4fOYDblvDuwFaQJNygxA").build();
    }

    @DisplayName("1. 사용자가 회원가입에 필요한 정보를 입력했을 때, 정상 가입되어야 한다.")
    @Test
    void register() {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(user);

        // when
        RegisterResponse registeredUser = authenticationService.register(registerRequestDto);
        Optional<Customer> customer = customerRepository.findById(registeredUser.getUserId());

        // then
        Assertions.assertNotNull(customer);
    }

    @DisplayName("2. 로그인 요청 시, 액세스 토큰과 리프레시 토큰이 발급되어야 한다.")
    @Test
    void login(){
        // given : 사용자가 로그인에 필요한 정보를 입력했을 때
        when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtService.generateToken(Mockito.any(Authentication.class))).thenReturn(response);

        // when
        AuthenticationResponse authenticationResponse = authenticationService.logIn(loginRequest);

        // then
        Assertions.assertNotNull(authenticationResponse);
        Assertions.assertNotNull(authenticationResponse.getAccessToken());
        Assertions.assertNotNull(authenticationResponse.getRefreshToken());
    }
}