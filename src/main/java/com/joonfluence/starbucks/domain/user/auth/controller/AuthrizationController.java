package com.joonfluence.starbucks.domain.user.auth.controller;

import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.global.dto.GlobalResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthrizationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/api/v1/auth")
    public ResponseEntity<String> testGet(){
        return ResponseEntity.status(200).body("Good");
    }

    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<GlobalResponse<AuthenticationResponse>> logIn(@RequestBody @Valid LoginRequest request){
        AuthenticationResponse authenticationResponse = authenticationService.logIn(request);
        return ResponseEntity.status(200).body(new GlobalResponse<AuthenticationResponse>(200, authenticationResponse, "로그인에 성공하였습니다."));
    }

    @PostMapping("/api/v1/auth/signUp")
    public ResponseEntity<GlobalResponse<Long>> signUp(@RequestBody @Valid RegisterRequest request){
        Long registeredUserId = authenticationService.register(request);
        return ResponseEntity.status(201).body(new GlobalResponse<Long>(201, registeredUserId, "회원가입이 완료되었습니다."));
    }
}
