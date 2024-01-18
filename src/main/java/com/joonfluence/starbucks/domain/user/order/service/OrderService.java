package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItem;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItemRepository;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.joonfluence.starbucks.domain.user.payment.service.PaymentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderServiceValidator orderServiceValidator;

    @Transactional(rollbackFor = {NoSuchProductException.class, NoSuchCustomerException.class})
    public Order createOrder(OrderRequestDto dto) {
        orderServiceValidator.validateCustomer(dto.getCustomerId());
        orderServiceValidator.validateProducts(dto.getProductIds());
        Customer customer = getCustomer(dto);
        Order orderEntity = dto.toEntity(dto);
        Order saved = createOrder(customer, orderEntity);
        createOrderItem(saved, dto.getProductIds());
        return saved;
    }

    @Transactional
    private Order createOrder(Customer customer, Order orderEntity) {
        orderEntity.updateCustomer(customer);
        return repository.save(orderEntity);
    }

    @Transactional
    private void createOrderItem(Order saved, List<Long> productIds) {
        productIds.forEach(p -> {
            Product product = getProductById(p);
            OrderItem orderItem = OrderItem.builder().order(saved).product(product).build();
            orderItemRepository.save(orderItem);
        });
    }

    public Order findById(Long orderId){
        return repository.findById(orderId).get();
    }

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
