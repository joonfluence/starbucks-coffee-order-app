package com.joonfluence.starbucks.domain.user.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.domain.user.auth.config.JwtAuthenticationFilter;
import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.global.dto.GlobalResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = AuthrizationController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AuthrizationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private JwtService jwtService;
    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @MockBean
    private AuthenticationService authenticationService;
    @Autowired
    private ObjectMapper objectMapper;

    private RegisterRequest registerRequestDto;
    private RegisterRequest notEnoughInfoRegisterRequestDto;
    private Customer user;

    @BeforeEach
    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
        notEnoughInfoRegisterRequestDto = RegisterRequest.builder().email("").name("Joonho").password("12341234").build();
        user = registerRequestDto.toEntity();
    }

    @DisplayName("1. 사용자가 회원가입에 정보를 잘못 입력했을 때, 가입되면 안된다.")
    @Test
    void not_registered_when_user_submit_wrong_value() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        given(authenticationService.register(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
        GlobalResponse<Long> responseDto = new GlobalResponse<Long>(201, 1L, "회원가입이 완료되었습니다.");

        // when
        ResultActions response = mockMvc.perform(post("http://localhost:8080/api/v1/auth/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(responseDto)));

        // then
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}