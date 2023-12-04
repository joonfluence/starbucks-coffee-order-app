package com.joonfluence.starbucks.domain.user.auth.service;

import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
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
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    JwtService jwtService;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    AuthenticationService authenticationService;

    private RegisterRequest registerRequestDto;
    private RegisterRequest blankRegisterRequestDto;
    private Customer user;
    private LoginRequest loginRequest;
    private Authentication authentication;

    @BeforeEach
    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
        blankRegisterRequestDto = RegisterRequest.builder().email("").name("Joonho").password("12341234").build();
        user = registerRequestDto.toEntity();
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("12341234").passwordRepeated("12341234").build();
    }

    @DisplayName("1. 사용자가 회원가입에 필요한 정보를 입력했을 때, 정상 가입되어야 한다.")
    @Test
    void register() {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(user);

        // when
        Long registeredUser = authenticationService.register(registerRequestDto);
        Optional<Customer> customer = customerRepository.findById(registeredUser);

        // then
        Assertions.assertNotNull(customer);
    }

    @DisplayName("2. 사용자가 로그인에 필요한 정보를 입력했을 때, 정상 로그인(토큰 반환) 되어야 한다.")
    @Test
    void logIn(){
        // given : 사용자가 로그인에 필요한 정보를 입력했을 때
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        // when
        AuthenticationResponse authenticationResponse = authenticationService.logIn(loginRequest);
        Boolean accessTokenValidated = jwtService.validateToken(authenticationResponse.getAccessToken());
        Boolean refreshTokenValidated = jwtService.validateToken(authenticationResponse.getRefreshToken());

        // then
        Assertions.assertNotNull(authenticationResponse);
        Assertions.assertTrue(accessTokenValidated);
        Assertions.assertTrue(refreshTokenValidated);
    }
}