package com.joonfluence.starbucks.domain.delivery.repository.jpa;

import com.joonfluence.starbucks.domain.delivery.dto.DeliverySaveDto;
import com.joonfluence.starbucks.domain.delivery.dto.DeliveryUpdateDto;
import com.joonfluence.starbucks.domain.delivery.entity.Delivery;
import com.joonfluence.starbucks.domain.delivery.repository.DeliveryRepository;
import com.joonfluence.starbucks.domain.user.entity.Member;
import com.joonfluence.starbucks.domain.user.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class DeliveryJpaRepository implements DeliveryRepository {
    @PersistenceContext
    EntityManager em;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long save(DeliverySaveDto dto) {
        Member member = memberRepository.findById(dto.getMemberId());
        Delivery delivery = Delivery.builder().name(dto.getName()).member(member).build();
        em.persist(delivery);
        return delivery.getId();
    }

    @Override
    public Delivery findById(Long memberId) {
        return em.find(Delivery.class, memberId);
    }

    @Override
    public List<Delivery> findAll() {
        return em.createQuery("select d from Delivery d", Delivery.class).getResultList();
    }

    @Override
    @Transactional
    public void update(DeliveryUpdateDto dto) {
        Delivery delivery = findById(dto.getId());
        Delivery newDelivery = Delivery.builder().id(dto.getId()).name(dto.getName()).likeCount(dto.getLikeCount()).build();
        delivery.update(newDelivery);
    }

    @Override
    public void delete(Delivery delivery) {
        em.remove(delivery);
    }
}