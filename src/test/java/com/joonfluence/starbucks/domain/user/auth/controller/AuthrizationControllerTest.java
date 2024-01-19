package com.joonfluence.starbucks.domain.user.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.filter.MockSpringSecurityFilter;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.global.security.JwtAuthenticationFilter;
import com.joonfluence.starbucks.global.security.SecurityConfiguration;
import com.joonfluence.starbucks.global.security.UserDetailsImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(
        controllers = {AuthrizationController.class},
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = { SecurityConfiguration.class, JwtAuthenticationFilter.class }
                )
        }
)
@ActiveProfiles("test")
class AuthrizationControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authenticationService;
    private Principal mockPrincipal;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;


    private RegisterRequest registerRequestDto;
    private RegisterRequest notEnoughInfoRegisterRequestDto;
    private LoginRequest loginRequest;
    private Customer user;
    private AuthenticationResponse response;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity(new MockSpringSecurityFilter()))
                .build();
        init();
    }

    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").nickName("Joonho").password("!abcd1234").build();
        notEnoughInfoRegisterRequestDto = RegisterRequest.builder().email("").nickName("Joonho").password("12341234").build();
        UserDetailsImpl testUserDetails = new UserDetailsImpl(registerRequestDto.toEntity());
        mockPrincipal = new UsernamePasswordAuthenticationToken(testUserDetails, "", testUserDetails.getAuthorities());
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("!abcd1234").passwordRepeated("!abcd1234").build();
        response = AuthenticationResponse.builder().accessToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAxNjg4NjA0fQ.VlSs4U8ferPP8Uh5QmumVmeO_OgRMwk8YK7_lSOAY5kFY3Hos1u14FvQNQQ3b_spTLSpsZOYOx7Rx5tgBL-95Q").refreshTokenUUid(UUID.randomUUID().toString()).build();
    }

    @DisplayName("1. 사용자가 회원가입에 정보를 입력했을 때, 정상 가입되어야 한다.")
    @Test
    void registered_when_user_submit_right_value() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        RegisterResponse responseDto = new RegisterResponse(1L, registerRequestDto.getNickName(), registerRequestDto.getEmail());
        given(authenticationService.register(registerRequestDto)).willReturn(responseDto);

        // when
        ResultActions response = mockMvc.perform(post("/api/v1/auth/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequestDto)));

        // then
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("회원가입이 완료되었습니다.")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.userId", CoreMatchers.is(responseDto.getUserId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is(responseDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email", CoreMatchers.is(responseDto.getEmail())));
    }

    @DisplayName("2. 사용자가 로그인에 필요한 정보를 입력했을 때, 정상 로그인(토큰 반환) 되어야 한다.")
    @Test
    void logIn() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        // when
        ResultActions mockResponse = mockMvc.perform(post("/api/v1/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)));

        MvcResult result = mockMvc.perform(post("/api/v1/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest))).andReturn();

        System.out.println("result.getResponse() = " + result.getResponse());;
        System.out.println(result.getResponse().getContentAsString());;

        // then
        mockResponse.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("로그인에 성공하였습니다.")));
    }
}