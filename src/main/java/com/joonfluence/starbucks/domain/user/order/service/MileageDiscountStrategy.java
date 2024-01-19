package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.coupon.entity.Coupon;
import com.joonfluence.starbucks.domain.user.coupon.repository.CouponRepository;
import com.joonfluence.starbucks.domain.user.order.Money;
import com.joonfluence.starbucks.domain.user.order.dto.request.CouponProduct;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

public class MileageDiscountStrategy implements DiscountStrategy {

    @Override
    public Money calculateDiscountedAmount(OrderRequestDto orderRequestDto) {
        Integer mileageAmount = orderRequestDto.getUsedMileageAmount();
        return Money.wons(orderRequestDto.getOrderPrice()).minus(Money.wons(mileageAmount));
    }
}
