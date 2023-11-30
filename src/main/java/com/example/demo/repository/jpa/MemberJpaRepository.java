package com.example.demo.repository.jpa;

import com.example.demo.domain.Member;
import com.example.demo.dto.member.MemberSaveDto;
import com.example.demo.dto.member.MemberUpdateDto;
import com.example.demo.repository.MemberRepository;
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