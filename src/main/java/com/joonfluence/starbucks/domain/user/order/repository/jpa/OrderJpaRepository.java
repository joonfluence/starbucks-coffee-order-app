package com.joonfluence.starbucks.domain.user.order.repository.jpa;

import com.joonfluence.starbucks.domain.user.order.dto.OrderSaveDto;
import com.joonfluence.starbucks.domain.user.order.dto.OrderUpdateDto;
import com.joonfluence.starbucks.domain.user.order.entity.Order;
import com.joonfluence.starbucks.domain.user.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class OrderJpaRepository implements OrderRepository {
    @PersistenceContext
    EntityManager em;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Long save(OrderSaveDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId());
        Order order = Order.builder().name(dto.getName()).customer(customer).build();
        em.persist(order);
        return order.getId();
    }

    @Override
    public Order findById(Long orderId) {
        return em.find(Order.class, orderId);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select p from orders p", Order.class).getResultList();
    }

    @Override
    @Transactional
    public void update(OrderUpdateDto dto) {
        Order order = findById(dto.getId());
        Order newOrder = order.builder().id(dto.getId()).name(dto.getName()).likeCount(dto.getLikeCount()).build();
        order.update(newOrder);
    }

    @Override
    public void delete(Order order) {
        em.remove(order);
    }
}