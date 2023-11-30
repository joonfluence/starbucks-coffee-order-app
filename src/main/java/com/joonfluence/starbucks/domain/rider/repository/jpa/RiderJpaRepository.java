package com.joonfluence.starbucks.domain.rider.repository.jpa;

import com.joonfluence.starbucks.domain.rider.dto.RiderSaveDto;
import com.joonfluence.starbucks.domain.rider.dto.RiderUpdateDto;
import com.joonfluence.starbucks.domain.rider.entity.Rider;
import com.joonfluence.starbucks.domain.rider.repository.RiderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class RiderJpaRepository implements RiderRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(RiderSaveDto dto) {
        Rider rider = Rider.builder().name(dto.getName()).build();
        em.persist(rider);
        return rider.getId();
    }

    @Override
    public Rider findById(Long memberId) {
        return em.find(Rider.class, memberId);
    }

    @Override
    public List<Rider> findAll() {
        return em.createQuery("select m from Member m", Rider.class).getResultList();
    }

    @Override
    public void update(RiderUpdateDto dto) {
        Rider rider = Rider.builder().id(dto.getId()).name(dto.getName()).build();
        rider.update(rider);
    }

    @Override
    public void delete(Rider rider) {
        em.remove(rider);
    }
}