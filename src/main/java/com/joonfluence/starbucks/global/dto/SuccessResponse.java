package com.joonfluence.starbucks.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum SuccessResponse {
    SUCCESS("성공"),
    FAIL("실패");
    String message;
}
