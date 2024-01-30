package com.joonfluence.starbucks.domain.user.delivery.repository;

import com.joonfluence.starbucks.domain.user.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.user.delivery.dto.DeliveryUpdateDto;
import com.joonfluence.starbucks.domain.user.delivery.entity.Delivery;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
