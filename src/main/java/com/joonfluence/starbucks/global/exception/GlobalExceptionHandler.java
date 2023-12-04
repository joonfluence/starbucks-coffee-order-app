package com.joonfluence.starbucks.global.exception;

import com.joonfluence.starbucks.domain.user.auth.exception.DuplicateUserEmailException;
import com.joonfluence.starbucks.global.dto.ErrorResponse;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import io.jsonwebtoken.JwtException;
=======
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
<<<<<<< HEAD
=======

>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
    @ExceptionHandler(DuplicateUserEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleDuplicateUserEmailException(DuplicateUserEmailException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }
}
