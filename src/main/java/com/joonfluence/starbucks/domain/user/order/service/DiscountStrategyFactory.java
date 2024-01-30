package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.dto.request.DiscountType;
import org.springframework.stereotype.Service;

@Service
public class DiscountStrategyFactory {
    public DiscountStrategy getDiscountStrategy(DiscountType discountType) {
        switch (discountType) {
            case COMPANY:
                return new CompanyDiscountStrategy();
            case MILEAGE:
                return new MileageDiscountStrategy();
            case EVENT:
                return new EventDiscountStrategy();
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }
    }
}
