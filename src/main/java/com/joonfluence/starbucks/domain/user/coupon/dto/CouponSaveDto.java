package com.joonfluence.starbucks.domain.user.coupon.dto;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponSaveDto {
    private Long customerId;
    private String name;
}
