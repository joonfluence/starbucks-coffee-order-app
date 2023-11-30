package com.joonfluence.starbucks.domain.delivery.service;

import com.joonfluence.starbucks.domain.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.delivery.dto.DeliveryUpdateDto;

public interface DeliveryService {
    Long createPost(DeliverySaveDto dto);
    void sendLike(DeliveryUpdateDto dto);
}
