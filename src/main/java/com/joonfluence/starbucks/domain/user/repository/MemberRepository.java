package com.joonfluence.starbucks.domain.user.repository;

import com.joonfluence.starbucks.domain.user.entity.Member;
import com.joonfluence.starbucks.domain.user.dto.member.MemberSaveDto;
import com.joonfluence.starbucks.domain.user.dto.member.MemberUpdateDto;

import java.util.List;

public interface MemberRepository {
    Long save(MemberSaveDto member);

    Member findById(Long memberId);

    List<Member> findAll();

    void update(MemberUpdateDto dto);

    void delete(Member member);
}
