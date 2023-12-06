package com.joonfluence.starbucks.domain.user.customer.controller;

<<<<<<< HEAD
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUser;
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck;
=======
<<<<<<< HEAD
=======
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUser;
<<<<<<< HEAD
>>>>>>> 820923e (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
<<<<<<< HEAD
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
import com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck;
>>>>>>> d4e6445 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
import com.joonfluence.starbucks.global.dto.GlobalResponse;
import com.joonfluence.starbucks.global.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 820923e (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)

@RequestMapping("/api/v1/users/me")
@RequiredArgsConstructor
@RestController
public class CustomerMeController {
    @PostMapping("/id/find")
<<<<<<< HEAD
<<<<<<< HEAD
    @CurrentUserCheck
    public ResponseEntity<GlobalResponse> findId(@CurrentUser Long userId){
=======
=======
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
<<<<<<< HEAD
    public ResponseEntity<GlobalResponse> findId(){
=======
=======
    @CurrentUserCheck
>>>>>>> d4e6445 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
    public ResponseEntity<GlobalResponse> findId(@CurrentUser Long userId){
>>>>>>> 820923e (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
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
