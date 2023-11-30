package com.joonfluence.starbucks.domain.delivery.dto;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliverySaveDto {
    private Long memberId;
    private String name;
}
