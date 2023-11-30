package com.joonfluence.starbucks.domain.user.delivery.service;

import com.joonfluence.starbucks.domain.user.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.user.delivery.dto.DeliveryUpdateDto;
import com.joonfluence.starbucks.domain.user.delivery.entity.Delivery;
import com.joonfluence.starbucks.domain.user.delivery.repository.DeliveryRepository;
import com.joonfluence.starbucks.domain.user.customer.service.NotificationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final NotificationService notificationService;

    @Override
    public Long createPost(DeliverySaveDto dto) {
        return deliveryRepository.save(dto);
    }

    @Override
    public void sendLike(DeliveryUpdateDto dto) {
        deliveryRepository.update(dto);
        Delivery delivery = deliveryRepository.findById(dto.getId());
        notificationService.NotifyUser(delivery.getCustomer().getId());
    }
}
