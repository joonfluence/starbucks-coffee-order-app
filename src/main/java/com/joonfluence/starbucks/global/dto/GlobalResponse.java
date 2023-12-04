package com.joonfluence.starbucks.global.dto;

import lombok.Builder;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalResponse<D> {
    private int statusCode;
    private String message;
    private D data;

    @Builder
    public GlobalResponse(int statusCode, D data, String message) {
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;
    }
}
