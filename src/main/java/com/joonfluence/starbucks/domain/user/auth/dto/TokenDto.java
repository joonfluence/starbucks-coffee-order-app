package com.joonfluence.starbucks.domain.user.auth.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {
    private String accessToken;
    private String refreshToken;
}