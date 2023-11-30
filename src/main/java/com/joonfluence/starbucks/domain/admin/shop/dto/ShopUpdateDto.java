package com.joonfluence.starbucks.domain.admin.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopUpdateDto {
    private Long id;
    private String name;
}
