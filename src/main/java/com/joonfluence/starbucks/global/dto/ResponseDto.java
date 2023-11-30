package com.joonfluence.starbucks.global.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseDto<D> {
    private int status;
    private String message;
    private D data;

    @Builder
    public ResponseDto(int status, D data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
