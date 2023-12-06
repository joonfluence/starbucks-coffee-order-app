package com.joonfluence.starbucks.domain.user.auth.controller;

import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RefreshTokenRequestDto;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUser;
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck;
import com.joonfluence.starbucks.global.dto.GlobalResponse;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 0c33959 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
=======
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
<<<<<<< HEAD
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
=======
=======
import jakarta.servlet.http.HttpServletRequest;
>>>>>>> 8d31ae2 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
>>>>>>> 0c33959 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@RestController
public class AuthrizationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/test")
    @CurrentUserCheck
    public ResponseEntity<String> testGet(@CurrentUser Long userId){
<<<<<<< HEAD
        System.out.println("[AuthrizationController.testGet] userId = " + userId);
=======
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
        return ResponseEntity.status(200).body("Good");
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @PostMapping("/login")
=======
    @PostMapping("/api/v1/auth/login")
>>>>>>> 2e820e8 (feat(Auth) : 로그인 기능 구현)
=======
    @PostMapping("/login")
>>>>>>> 8d31ae2 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> logIn(@RequestBody @Valid LoginRequest request){
        AuthenticationResponse authenticationResponse = authenticationService.logIn(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @PostMapping("/signUp")
    public ResponseEntity<GlobalResponse<RegisterResponse>> signUp(@RequestBody @Valid RegisterRequest request){
        RegisterResponse response = authenticationService.register(request);
        return ResponseEntity.status(201).body(new GlobalResponse<RegisterResponse>(201, response, "회원가입이 완료되었습니다."));
    }

    @PostMapping("/refresh-token")
<<<<<<< HEAD
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> refreshToken(@RequestBody RefreshTokenRequestDto dto) throws IOException {
        AuthenticationResponse tokenDto = authenticationService.refreshToken(dto);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, tokenDto, "액세스 토큰 발급에 성공하였습니다."));
=======
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> refreshToken(HttpServletRequest request) throws IOException {
        AuthenticationResponse authenticationResponse = authenticationService.refreshToken(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
=======
    @PostMapping("/api/v1/auth/signUp")
=======
    @PostMapping("/signUp")
>>>>>>> 8d31ae2 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
    public ResponseEntity<GlobalResponse<Long>> signUp(@RequestBody @Valid RegisterRequest request){
        Long registeredUserId = authenticationService.register(request);
        return ResponseEntity.status(201).body(new GlobalResponse<Long>(201, registeredUserId, "회원가입이 완료되었습니다."));
    }
<<<<<<< HEAD
<<<<<<< HEAD

    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> logIn(AuthenticationRequest dto){
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>());
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
    }
=======
>>>>>>> 2e820e8 (feat(Auth) : 로그인 기능 구현)
=======

    @PostMapping("/refresh-token")
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> refreshToken(HttpServletRequest request) throws IOException {
        AuthenticationResponse authenticationResponse = authenticationService.refreshToken(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
    }
>>>>>>> 8d31ae2 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
}
