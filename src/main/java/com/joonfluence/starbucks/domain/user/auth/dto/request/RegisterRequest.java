package com.joonfluence.starbucks.domain.user.auth.dto.request;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    @NotEmpty(message = "이름 입력은 필수입니다")
    private String name;

    @NotEmpty(message = "이메일 입력은 필수입니다")
    @Email(message = "이메일을 양식을 지켜주세요.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    @NotEmpty(message = "비밀번호 입력은 필수입니다")
    private String password;

    public Customer toEntity(){
        return Customer.builder().name(name).email(email).password(password).build();
    }
}
