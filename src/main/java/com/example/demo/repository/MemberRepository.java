package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.dto.member.MemberSaveDto;
import com.example.demo.dto.member.MemberUpdateDto;

import java.util.List;

public interface MemberRepository {
    Long save(MemberSaveDto member);

    Member findById(Long memberId);

    List<Member> findAll();

    void update(MemberUpdateDto dto);

    void delete(Member member);
}
