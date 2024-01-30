package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.entity.ProductPrice;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductStatus;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductType;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductPriceRepository;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItem;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItemRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderIntegrationTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

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
    private OrderRequestDto orderNoCustomerRequest;
    private OrderRequestDto orderNoProductRequest;

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
        orderNoCustomerRequest = OrderRequestDto.builder().customerId(testCustomer.getId()).productIds(testProductIds).build();
        orderNoProductRequest = OrderRequestDto.builder().customerId(testCustomer.getId()).productIds(testProductIds).build();
    }

    @Nested
    @DisplayName("createOrder 메소드는")
    class Describe_createOrder {
        @DisplayName("상품 혹은 고객 정보가 전부 존재하면 주문 정보가 생성되어야 한다.")
        @Test
        void test() {
            // given
            customerRepository.save(testCustomer);
            productPriceRepository.save(testProductPrice);
            productRepository.save(testProduct);
            productRepository.save(testProduct2);
            // when
            Order savedOrder = orderService.createOrder(orderNoProductRequest);
            List<OrderItem> orderItems = orderItemRepository.findAll();
            // then
            Order byId = orderService.findById(savedOrder.getId());
            Assertions.assertEquals(byId.getId(), savedOrder.getId());
            Assertions.assertEquals(2, orderItems.size());
        }
    }
}
