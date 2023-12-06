package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderRepository repository;
    @BeforeEach
    void setUp() {

    }

    @DisplayName("1. 정상적으로 주문 처리되어야 한다.")
    @Test
    void 주문시_정상_주문_결제_처리되어야_한다() {
        // given
        // when
        // then
    }

    @DisplayName("2. ")
    @Test
    void test_2(){
        // given
        // when
        // then
    }
}