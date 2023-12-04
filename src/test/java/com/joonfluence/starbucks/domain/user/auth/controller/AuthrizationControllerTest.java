package com.joonfluence.starbucks.domain.user.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.global.security.JwtService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthrizationControllerTest {
    @MockBean
    AuthenticationService authenticationService;
    @Autowired
    MockMvc mockMvc;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    JwtService jwtService;
    @Mock
    Authentication authentication;
    @Autowired
    ObjectMapper objectMapper;
    RegisterRequest registerRequestDto;
    RegisterRequest notEnoughInfoRegisterRequestDto;
    LoginRequest loginRequest;
    Customer user;
    AuthenticationResponse response;

    @BeforeEach
    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
        notEnoughInfoRegisterRequestDto = RegisterRequest.builder().email("").name("Joonho").password("12341234").build();
        user = registerRequestDto.toEntity();
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("!abcd1234").passwordRepeated("!abcd1234").build();
        response = AuthenticationResponse.builder().accessToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAxNjg4NjA0fQ.VlSs4U8ferPP8Uh5QmumVmeO_OgRMwk8YK7_lSOAY5kFY3Hos1u14FvQNQQ3b_spTLSpsZOYOx7Rx5tgBL-95Q").refreshToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAyMjkxNjA0fQ.G5xYWiC8xN5vhZtT_QQ_wEk8_y0SAsmODF2oqLC7KS-JEjvKPYKYIiv6GUf4b1tlfT4fOYDblvDuwFaQJNygxA").build();
    }

    @DisplayName("1. 사용자가 회원가입에 정보를 입력했을 때, 정상 가입되어야 한다.")
    @Test
    void registered_when_user_submit_right_value() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        RegisterResponse responseDto = new RegisterResponse(1L, registerRequestDto.getName(), registerRequestDto.getEmail());
        when(authenticationService.register(registerRequestDto)).thenReturn(responseDto);

        // when
        ResultActions response = mockMvc.perform(post("/api/v1/auth/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequestDto)));

        // then
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is(responseDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email", CoreMatchers.is(responseDto.getEmail())));
    }

    @DisplayName("2. 사용자가 로그인에 필요한 정보를 입력했을 때, 정상 로그인(토큰 반환) 되어야 한다.")
    @Test
    void logIn() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtService.generateToken(Mockito.any(Authentication.class))).thenReturn(response);
        when(authenticationService.logIn(loginRequest)).thenReturn(response);

        // when
        ResultActions mockResponse = mockMvc.perform(post("/api/v1/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)));

        // then
        mockResponse.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.access_token", CoreMatchers.is(response.getAccessToken())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.refresh_token", CoreMatchers.is(response.getRefreshToken())));
    }
}