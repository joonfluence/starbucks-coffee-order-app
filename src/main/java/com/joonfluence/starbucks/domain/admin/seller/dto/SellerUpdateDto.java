package com.joonfluence.starbucks.domain.admin.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerUpdateDto {
    private Long id;
    private String name;
}
