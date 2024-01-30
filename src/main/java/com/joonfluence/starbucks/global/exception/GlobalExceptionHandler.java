package com.joonfluence.starbucks.global.exception;

import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.user.auth.exception.DuplicateUserEmailException;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.order.service.NoSuchOrderException;
import com.joonfluence.starbucks.global.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateUserEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleDuplicateUserEmailException(DuplicateUserEmailException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }

    @ExceptionHandler(NoSuchProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleNoSuchProductException(NoSuchProductException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }

    @ExceptionHandler(NoSuchCustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleNoSuchCustomerException(NoSuchCustomerException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }

    @ExceptionHandler(NoSuchOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleNoSuchOrderException(NoSuchOrderException ex) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }
}
