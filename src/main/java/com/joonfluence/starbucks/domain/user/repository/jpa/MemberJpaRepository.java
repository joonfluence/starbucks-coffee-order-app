package com.joonfluence.starbucks.domain.user.repository.jpa;

import com.joonfluence.starbucks.domain.user.entity.Member;
import com.joonfluence.starbucks.domain.user.dto.member.MemberSaveDto;
import com.joonfluence.starbucks.domain.user.dto.member.MemberUpdateDto;
import com.joonfluence.starbucks.domain.user.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class MemberJpaRepository implements MemberRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(MemberSaveDto dto) {
        Member member = Member.builder().name(dto.getName()).build();
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(Long memberId) {
        return em.find(Member.class, memberId);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public void update(MemberUpdateDto dto) {
        Member member = Member.builder().id(dto.getId()).name(dto.getName()).build();
        member.update(member);
    }

    @Override
    public void delete(Member member) {
        em.remove(member);
    }
}