package com.joonfluence.starbucks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.domain.user.auth.controller.AuthrizationController;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class DemoApplicationIntegerationTests {
	@Autowired
	AuthrizationController authrizationController;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;

	private RegisterRequest registerRequestDto;

	@BeforeEach
	public void setup() {
		init();
	}

	public void init(){
		registerRequestDto = RegisterRequest.builder().email("joonfluence.dev@gmail.com").name("Joonho").password("!abcd1234").build();
	}

	@DisplayName("회원가입을 진행할 때, 정상 가입되어야 한다.")
	@Test
	void test() throws Exception {
		// given : 사용자가 회원가입에 필요한 정보를 입력했을 때
		RegisterResponse responseDto = new RegisterResponse(1L, registerRequestDto.getName(), registerRequestDto.getEmail());

		// when
		ResultActions response = mockMvc.perform(post("/api/v1/auth/signUp")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(registerRequestDto)));

		MvcResult result = response.andReturn();
		System.out.println("result = " + result.getResponse().getContentAsString());

		// then
		response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("회원가입이 완료되었습니다.")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.userId", CoreMatchers.is(responseDto.getUserId().intValue())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is(responseDto.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.email", CoreMatchers.is(responseDto.getEmail())));
	}
}
