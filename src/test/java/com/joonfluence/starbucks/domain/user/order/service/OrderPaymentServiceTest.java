package com.joonfluence.starbucks.domain.user.order.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class OrderPaymentServiceTest {

    @Nested
    @DisplayName("processOrderAndPayment 메소드는")
    class Describe_processOrderAndPayment {
        @Nested
        @DisplayName("아무런 할인 정책을 선택하지 않았을 때")
        class Context_with_no_discount {

        }
    }
}