package com.joonfluence.starbucks.domain.user.auth.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    @NotEmpty(message = "이메일 입력은 필수입니다")
    private String email;
    @NotEmpty(message = "비밀번호 입력은 필수입니다")
    private String password;
    @NotEmpty(message = "2차 비밀번호 입력은 필수입니다")
    private String passwordRepeated;
}
