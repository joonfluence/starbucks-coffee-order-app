package com.joonfluence.starbucks.domain.user.delivery.dto;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliverySaveDto {
    private Long customerId;
    private String name;
}
