package com.joonfluence.starbucks.domain.user.payment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentUpdateDto {
    private Long id;
    private String name;
    private int likeCount;
}
