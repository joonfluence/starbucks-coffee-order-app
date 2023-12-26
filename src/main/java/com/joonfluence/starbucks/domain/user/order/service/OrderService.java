package com.joonfluence.starbucks.domain.user.order.service;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ac42eea (feat(Order): Create Order logic in Order Service Layer)
import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.coupon.repository.CouponRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
<<<<<<< HEAD
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;

    @Transactional
    public Order createOrder(OrderRequestDto dto) {
        Product product = findProductById(dto.getProductId());
        Customer customer = findCustomerById(dto.getCustomerId());

        Order orderEntity = dto.toEntity(dto);
        orderEntity.updateProduct(product);
        orderEntity.updateCustomer(customer);

        return repository.save(orderEntity);
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> {
            throw new NoSuchProductException("해당 상품이 존재하지 않습니다");
        });
    }
    private Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> {
            throw new NoSuchCustomerException("해당 유저가 존재하지 않습니다");
        });
    }
}
=======
import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;
=======
>>>>>>> ac42eea (feat(Order): Create Order logic in Order Service Layer)
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
<<<<<<< HEAD
public class OrderService {}
>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
=======
public class OrderService {
    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final PaymentService paymentService;

    @Transactional
    public Long orderProduct(OrderRequestDto dto){
        Long orderId = createOrder(dto);
        paymentService.payOrder();
        return orderId;
    }

    private void payOrder() {
        return;
    }

    @Transactional
    private Long createOrder(OrderRequestDto dto) {
        Product product = findProductById(dto.getProductId());
        Customer customer = findCustomerById(dto.getCustomerId());

        Order orderEntity = dto.toEntity(dto);
        orderEntity.updateProduct(product);
        orderEntity.updateCustomer(customer);

        Order saved = repository.save(orderEntity);
        return saved.getId();
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> {
            throw new NoSuchProductException("해당 상품이 존재하지 않습니다");
        });
    }
    private Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> {
            throw new NoSuchCustomerException("해당 유저가 존재하지 않습니다");
        });
    }
}
>>>>>>> ac42eea (feat(Order): Create Order logic in Order Service Layer)
