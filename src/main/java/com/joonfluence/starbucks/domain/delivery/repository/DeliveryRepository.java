package com.joonfluence.starbucks.domain.delivery.repository;

import com.joonfluence.starbucks.domain.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.delivery.dto.DeliveryUpdateDto;
import com.joonfluence.starbucks.domain.delivery.entity.Delivery;

import java.util.List;

public interface DeliveryRepository {
    Long save(DeliverySaveDto dto);

    Delivery findById(Long postId);

    List<Delivery> findAll();

    void update(DeliveryUpdateDto dto);

    void delete(Delivery delivery);
}
