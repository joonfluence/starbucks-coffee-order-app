package com.joonfluence.starbucks.domain.order.repository.jpa;

import com.joonfluence.starbucks.domain.order.dto.post.OrderSaveDto;
import com.joonfluence.starbucks.domain.order.dto.post.OrderUpdateDto;
import com.joonfluence.starbucks.domain.order.entity.Order;
import com.joonfluence.starbucks.domain.order.repository.OrderRepository;
import com.joonfluence.starbucks.domain.user.entity.Member;
import com.joonfluence.starbucks.domain.user.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class OrderJpaRepository implements OrderRepository {
    @PersistenceContext
    EntityManager em;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long save(OrderSaveDto dto) {
        Member member = memberRepository.findById(dto.getMemberId());
        Order order = Order.builder().name(dto.getName()).member(member).build();
        em.persist(order);
        return order.getId();
    }

    @Override
    public Order findById(Long memberId) {
        return em.find(Order.class, memberId);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select p from order p", Order.class).getResultList();
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