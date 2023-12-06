package com.joonfluence.starbucks.global.dto;

<<<<<<< HEAD
public enum SuccessResponse {
    SUCCESS,
    FAIL
=======
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum SuccessResponse {
    SUCCESS("성공"),
    FAIL("실패");
    String message;
=======
public enum SuccessResponse {
    SUCCESS,
    FAIL
>>>>>>> 820923e (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
}
