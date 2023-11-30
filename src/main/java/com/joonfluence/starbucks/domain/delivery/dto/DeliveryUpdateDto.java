package com.joonfluence.starbucks.domain.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryUpdateDto {
    private Long id;
    private String name;
    private int likeCount;
}
