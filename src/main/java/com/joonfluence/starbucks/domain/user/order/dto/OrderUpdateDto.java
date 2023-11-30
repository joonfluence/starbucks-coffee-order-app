package com.joonfluence.starbucks.domain.user.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateDto {
    private Long id;
    private String name;
    private int likeCount;
}
