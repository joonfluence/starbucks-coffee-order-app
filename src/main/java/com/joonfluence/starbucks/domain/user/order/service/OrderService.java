package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.admin.product.service.ProductService;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.exception.NoSuchCustomerException;
import com.joonfluence.starbucks.domain.user.customer.service.CustomerService;
import com.joonfluence.starbucks.domain.user.order.dto.request.OrderRequestDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItem;
import com.joonfluence.starbucks.domain.user.order.entity.OrderItemRepository;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderItemRepository orderItemRepository;
    private final OrderServiceValidator orderServiceValidator;
    private final ProductService productService;
    private final CustomerService customerService;

    @Transactional(rollbackFor = {NoSuchProductException.class, NoSuchCustomerException.class})
    public Order createOrder(OrderRequestDto dto) {
        orderServiceValidator.validateCustomer(dto.getCustomerId());
        orderServiceValidator.validateProducts(dto.getProductIds());
        Customer customer = customerService.getCustomer(dto.getCustomerId());
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
            Product product = productService.getProductById(p);
            OrderItem orderItem = OrderItem.builder().order(saved).product(product).build();
            orderItemRepository.save(orderItem);
        });
    }

    public Order findById(Long orderId){
        return repository.findById(orderId).get();
    }
}
