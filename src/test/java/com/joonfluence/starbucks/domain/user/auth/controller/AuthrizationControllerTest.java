package com.joonfluence.starbucks.domain.user.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.joonfluence.starbucks.filter.MockSpringSecurityFilter;
=======
<<<<<<< HEAD
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
=======
=======
>>>>>>> 2ed1c99 (fix(Auth) : Customer Repository 테스트 (2))
<<<<<<< HEAD
=======
import com.joonfluence.starbucks.MockSpringSecurityFilter;
>>>>>>> e6bf88f (fix(Auth) : Customer Repository 테스트)
<<<<<<< HEAD
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
=======
=======
import com.joonfluence.starbucks.filter.MockSpringSecurityFilter;
>>>>>>> 633b215 (fix(Auth) : Customer Repository 테스트 (2))
>>>>>>> 2ed1c99 (fix(Auth) : Customer Repository 테스트 (2))
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.global.security.JwtAuthenticationFilter;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.joonfluence.starbucks.global.security.JwtService;
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
=======
>>>>>>> 2ed1c99 (fix(Auth) : Customer Repository 테스트 (2))
import com.joonfluence.starbucks.global.security.SecurityConfiguration;
import com.joonfluence.starbucks.global.security.UserDetailsImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
=======
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
>>>>>>> e15a14e (test(Auth) : Customer Repository 테스트)
=======
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.test.context.ActiveProfiles;
=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
=======
import org.springframework.test.context.ActiveProfiles;
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

<<<<<<< HEAD
=======
=======
import java.util.UUID;
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
@WebMvcTest(
        controllers = {AuthrizationController.class},
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = { SecurityConfiguration.class, JwtAuthenticationFilter.class }
                )
        }
)
<<<<<<< HEAD
<<<<<<< HEAD
@ActiveProfiles("test")
=======
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AuthrizationController.class)
>>>>>>> e15a14e (test(Auth) : Customer Repository 테스트)
=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
=======
@ActiveProfiles("test")
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
class AuthrizationControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authenticationService;
    private Principal mockPrincipal;
    @Autowired
    private WebApplicationContext context;
    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    private ObjectMapper objectMapper;


    private RegisterRequest registerRequestDto;
    private RegisterRequest notEnoughInfoRegisterRequestDto;
    private LoginRequest loginRequest;
    private Customer user;
    private AuthenticationResponse response;
=======
=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
    ObjectMapper objectMapper;
    RegisterRequest registerRequestDto;
    RegisterRequest notEnoughInfoRegisterRequestDto;
    LoginRequest loginRequest;
    Customer user;
    AuthenticationResponse response;
=======
import com.joonfluence.starbucks.domain.user.auth.config.JwtAuthenticationFilter;
import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@WebMvcTest(controllers = AuthrizationController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AuthrizationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authenticationService;
    @Autowired
=======
>>>>>>> e6bf88f (fix(Auth) : Customer Repository 테스트)
    private ObjectMapper objectMapper;


    private RegisterRequest registerRequestDto;
    private RegisterRequest notEnoughInfoRegisterRequestDto;
    private LoginRequest loginRequest;
    private Customer user;
<<<<<<< HEAD
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
<<<<<<< HEAD
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
=======
=======
    private AuthenticationResponse response;
>>>>>>> e6bf88f (fix(Auth) : Customer Repository 테스트)
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity(new MockSpringSecurityFilter()))
                .build();
        init();
    }

    public void init(){
        registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
        notEnoughInfoRegisterRequestDto = RegisterRequest.builder().email("").name("Joonho").password("12341234").build();
<<<<<<< HEAD
<<<<<<< HEAD
        UserDetailsImpl testUserDetails = new UserDetailsImpl(registerRequestDto.toEntity());
        mockPrincipal = new UsernamePasswordAuthenticationToken(testUserDetails, "", testUserDetails.getAuthorities());
=======
        user = registerRequestDto.toEntity();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
=======
<<<<<<< HEAD
>>>>>>> 3613cf4 (test(Auth) : Mockito로 로그인 기능 테스트)
=======
        user = registerRequestDto.toEntity();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        UserDetailsImpl testUserDetails = new UserDetailsImpl(registerRequestDto.toEntity());
        mockPrincipal = new UsernamePasswordAuthenticationToken(testUserDetails, "", testUserDetails.getAuthorities());
>>>>>>> e6bf88f (fix(Auth) : Customer Repository 테스트)
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("!abcd1234").passwordRepeated("!abcd1234").build();
        response = AuthenticationResponse.builder().accessToken("eyJhbGciOiJIUzUxMiJ9.eyJhdXRoIjoiUk9MRV9VU0VSIiwic3ViIjoiNyIsImlhdCI6MTcwMTY4NjgwNCwiZXhwIjoxNzAxNjg4NjA0fQ.VlSs4U8ferPP8Uh5QmumVmeO_OgRMwk8YK7_lSOAY5kFY3Hos1u14FvQNQQ3b_spTLSpsZOYOx7Rx5tgBL-95Q").refreshTokenUUid(UUID.randomUUID().toString()).build();
    }

    @DisplayName("1. 사용자가 회원가입에 정보를 입력했을 때, 정상 가입되어야 한다.")
    @Test
    void registered_when_user_submit_right_value() throws Exception {
        // given : 사용자가 회원가입에 필요한 정보를 입력했을 때
        RegisterResponse responseDto = new RegisterResponse(1L, registerRequestDto.getName(), registerRequestDto.getEmail());
<<<<<<< HEAD
        given(authenticationService.register(registerRequestDto)).willReturn(responseDto);
=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)

        // when
        ResultActions response = mockMvc.perform(post("/api/v1/auth/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequestDto)));

        MvcResult result = mockMvc.perform(post("/api/v1/auth/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequestDto))).andReturn();

        System.out.println("result.getResponse() = " + result.getResponse());;
        System.out.println("result.getResponse().getContentAsString() = " + result.getResponse().getContentAsString());

        // then
        response.andExpect(MockMvcResultMatchers.status().isCreated())
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("회원가입이 완료되었습니다.")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.userId", CoreMatchers.is(responseDto.getUserId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is(responseDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email", CoreMatchers.is(responseDto.getEmail())));
=======
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("회원가입이 완료되었습니다.")));
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
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
<<<<<<< HEAD
<<<<<<< HEAD
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("로그인에 성공하였습니다.")));
=======
=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.access_token", CoreMatchers.is(response.getAccessToken())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.refresh_token", CoreMatchers.is(response.getRefreshToken())));
=======
=======
        loginRequest = LoginRequest.builder().email("joonfluence.dev@gmail.com").password("12341234").passwordRepeated("12341234").build();
>>>>>>> 8827480 (test(Auth) : Mockito로 로그인 기능 테스트)
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
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
    }

    @DisplayName("2. 사용자가 로그인에 필요한 정보를 입력했을 때, 정상 로그인(토큰 반환) 되어야 한다.")
    @Test
    void logIn(){

=======
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("로그인에 성공하였습니다.")));
>>>>>>> e6bf88f (fix(Auth) : Customer Repository 테스트)
    }
}