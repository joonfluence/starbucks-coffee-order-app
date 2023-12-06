package com.joonfluence.starbucks.domain.user.customer.controller;

import com.joonfluence.starbucks.global.dto.GlobalResponse;
import com.joonfluence.starbucks.global.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users/me")
@RequiredArgsConstructor
@RestController
public class CustomerMeController {
    @PostMapping("/id/find")
    public ResponseEntity<GlobalResponse> findId(){
        return ResponseEntity.status(200).body(new GlobalResponse(200, "findId에 성공하였습니다.", SuccessResponse.SUCCESS));
    }

    @PostMapping("/password/find")
    public ResponseEntity<GlobalResponse> findPassword(){
        return ResponseEntity.status(200).body(new GlobalResponse(200, "findPassword에 성공하였습니다.", SuccessResponse.SUCCESS));
    }

    @PatchMapping("/password")
    public ResponseEntity<GlobalResponse> changePassword(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.status(200).body(new GlobalResponse(200, "changePassword에 성공하였습니다.", SuccessResponse.SUCCESS));
    }

    @PatchMapping("/quit")
    public ResponseEntity<GlobalResponse> accountQuit(){
        return ResponseEntity.status(200).body(new GlobalResponse(200, "회원탈퇴에 성공하였습니다.", SuccessResponse.SUCCESS));
    }
}
