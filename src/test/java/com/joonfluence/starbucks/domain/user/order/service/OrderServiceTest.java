package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.entity.ProductPrice;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductStatus;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductType;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.coupon.entity.Coupon;
import com.joonfluence.starbucks.domain.user.coupon.repository.CouponRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.CouponProduct;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItem;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItemRepository;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    OrderServiceValidator orderServiceValidator;
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderItemRepository orderItemRepository;
    @InjectMocks
    OrderService orderService;
    private Customer testCustomer;
    private Product testProduct;
    private Product testProduct2;
    private List<Long> testProductIds;
    private ProductPrice testProductPrice;
    private Order testOrder;
    private List<OrderItem> testOrderItems;
    private OrderItem orderItem;
    private OrderItem orderItem2;
    private OrderRequestDto orderNoCouponRequest;

    @BeforeEach
    void setUp() {
        testCustomer = Customer.builder().id(1L).nickName("Joonho").email("joonfluence.dev@gmail.com").password("!@#gmlfkr7236").build();
        testProductPrice = ProductPrice.builder().price(10000L).build();
        testProduct = Product.builder().id(1L).name("아메리카노").productStatus(ProductStatus.ON_SALE).productType(ProductType.COFFEE).productPrice(testProductPrice).build();
        testProduct2 = Product.builder().id(1L).name("아메리카노").productStatus(ProductStatus.ON_SALE).productType(ProductType.COFFEE).productPrice(testProductPrice).build();
        testProductIds = List.of(testProduct.getId(), testProduct2.getId());
        orderItem = OrderItem.builder().product(testProduct).build();
        orderItem2 = OrderItem.builder().product(testProduct2).build();
        testOrderItems = List.of(orderItem, orderItem2);
        testOrder = Order.builder().id(1L).customer(testCustomer).orderItems(testOrderItems).build();
        orderNoCouponRequest = OrderRequestDto.builder().customerId(testCustomer.getId()).productIds(testProductIds).build();
    }

    @Nested
    @DisplayName("createOrder 메소드는")
    class Describe_createOrder {
        @DisplayName("쿠폰/할인 등 어떠한 옵션 선택 없이 주문하는 경우, 정상적으로 주문 처리되어야 한다.")
        @Test
        void 주문시_정상_주문_결제_처리되어야_한다() {
            // given
            when(customerRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(testCustomer));
            when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(testProduct));
            when(orderRepository.save(Mockito.any(Order.class))).thenReturn(testOrder);
            when(orderItemRepository.save(Mockito.any(OrderItem.class))).thenReturn(orderItem);

            // when
            Order order = orderService.createOrder(orderNoCouponRequest);

            // then
            Assertions.assertEquals(order.getId(), testOrder.getId());
            Assertions.assertEquals(order.getOrderItems(), testOrderItems);
            Assertions.assertEquals(order.getCustomer(), testCustomer);
        }

        @DisplayName("존재하지 않는 ProductId를 선택했을 때, 생성되면 안된다.")
        @Test
        void 존재하지_않는_ProductId를_선택했을_때_생성되면_안된다(){
            // given
            when(customerRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(testCustomer));
            when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(null));

            // when & then
            Assertions.assertThrows(NoSuchProductException.class, () -> orderService.createOrder(orderNoCouponRequest));
            Assertions.assertThrows(NoSuchElementException.class, () -> orderService.findById(testOrder.getId()));
        }

        @DisplayName("존재하지 않는 CustomerId를 선택했을 때, 생성되면 안된다.")
        @Test
        void 존재하지_않는_CustomerId를_선택했을_때_생성되면_안된다(){
            // given
            when(customerRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(null));

            // when & then
            Assertions.assertThrows(NoSuchCustomerException.class, () -> orderService.createOrder(orderNoCouponRequest));
            Assertions.assertThrows(NoSuchElementException.class, () -> orderService.findById(testOrder.getId()));
        }
    }
}