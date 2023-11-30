package com.joonfluence.starbucks.domain.user.delivery.service;

import com.joonfluence.starbucks.domain.user.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.user.delivery.dto.DeliveryUpdateDto;

public interface DeliveryService {
    Long createPost(DeliverySaveDto dto);
    void sendLike(DeliveryUpdateDto dto);
}
