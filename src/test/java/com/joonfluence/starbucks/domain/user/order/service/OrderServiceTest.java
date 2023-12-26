package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.entity.ProductPrice;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductStatus;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductType;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.coupon.entity.Coupon;
import com.joonfluence.starbucks.domain.user.coupon.repository.CouponRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CouponRepository couponRepository;
    @Mock
    OrderRepository orderRepository;
    @InjectMocks
    OrderService orderService;
    private Customer testCustomer;
    private Product testProduct;
    private ProductPrice testProductPrice;
    private Coupon testCoupon;
    private Order testOrder;
    private OrderRequestDto orderNoCouponRequest;

    @BeforeEach
    void setUp() {
        testCustomer = Customer.builder().id(1L).nickName("Joonho").email("joonfluence.dev@gmail.com").password("!@#gmlfkr7236").build();
        testProductPrice = ProductPrice.builder().price(10000L).build();
        testProduct = Product.builder().id(1L).name("아메리카노").productStatus(ProductStatus.ON_SALE).productType(ProductType.COFFEE).productPrice(testProductPrice).build();
        testOrder = Order.builder().customer(testCustomer).product(testProduct).build();
        orderNoCouponRequest = OrderRequestDto.builder().customerId(testCustomer.getId()).productId(testProduct.getId()).build();
    }

    @DisplayName("1. 쿠폰/할인 등 어떠한 옵션 선택 없이 주문하는 경우, 정상적으로 주문 처리되어야 한다.")
    @Test
    void 주문시_정상_주문_결제_처리되어야_한다() {
        // given
        when(customerRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(testCustomer));
        when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(testProduct));
        when(orderRepository.save(Mockito.any(Order.class))).thenReturn(testOrder);

        // when
        Order order = orderService.createOrder(orderNoCouponRequest);

        // then
        Assertions.assertEquals(order.getId(), testOrder.getId());
        Assertions.assertEquals(order.getProduct(), testProduct);
        Assertions.assertEquals(order.getCustomer(), testCustomer);
    }

    @DisplayName("2. 임직원의 경우, 30% 일괄 할인 되어야 한다.")
    @Test
    void test_3(){
        // given
        // when
        // then
    }

    @DisplayName("3. 쿠폰 옵션을 선택하고 주문하는 경우, 정상적으로 쿠폰 할인이 적용되어 주문 처리되어야 한다.")
    @Test
    void test_2(){
        // given

        // when

        // then

    }


    @DisplayName("4. ")
    @Test
    void test_4(){
        // given
        // when
        // then
    }
}