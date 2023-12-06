package com.joonfluence.starbucks.domain.user.auth.controller;

import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUser;
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck;
import com.joonfluence.starbucks.global.dto.GlobalResponse;
import jakarta.servlet.http.HttpServletRequest;
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
        System.out.println("[AuthrizationController.testGet] userId = " + userId);
        return ResponseEntity.status(200).body("Good");
    }

    @PostMapping("/login")
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> logIn(@RequestBody @Valid LoginRequest request){
        AuthenticationResponse authenticationResponse = authenticationService.logIn(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
    }

    @PostMapping("/signUp")
    public ResponseEntity<GlobalResponse<RegisterResponse>> signUp(@RequestBody @Valid RegisterRequest request){
        RegisterResponse response = authenticationService.register(request);
        return ResponseEntity.status(201).body(new GlobalResponse<RegisterResponse>(201, response, "회원가입이 완료되었습니다."));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> refreshToken(HttpServletRequest request) throws IOException {
        AuthenticationResponse authenticationResponse = authenticationService.refreshToken(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
    }
}
