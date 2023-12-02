package com.joonfluence.starbucks.domain.user.auth.controller;

import com.joonfluence.starbucks.domain.user.auth.dto.request.AuthenticationRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.service.AuthenticationService;
import com.joonfluence.starbucks.global.dto.GlobalResponseDto;
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

    @PostMapping("/api/v1/auth")
    public ResponseEntity<String> testPost(){
        return ResponseEntity.status(200).body("Good");
    }

    @PostMapping("/api/v1/auth/signUp")
    public ResponseEntity<GlobalResponseDto<Boolean>> signUp(@RequestBody RegisterRequest request){
        authenticationService.register(request);
        return ResponseEntity.status(201).body(new GlobalResponseDto<Boolean>(201, true, "회원가입이 완료되었습니다."));
    }

    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<GlobalResponseDto<AuthenticationResponse>> logIn(AuthenticationRequest dto){
        return ResponseEntity.status(200).body(new GlobalResponseDto<AuthenticationResponse>());
    }
}
