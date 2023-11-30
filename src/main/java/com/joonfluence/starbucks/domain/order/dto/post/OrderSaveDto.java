package com.joonfluence.starbucks.domain.order.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSaveDto {
    private Long memberId;
    private String name;
}
