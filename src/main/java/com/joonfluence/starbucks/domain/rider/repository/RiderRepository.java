package com.joonfluence.starbucks.domain.rider.repository;

import com.joonfluence.starbucks.domain.rider.dto.RiderSaveDto;
import com.joonfluence.starbucks.domain.rider.dto.RiderUpdateDto;
import com.joonfluence.starbucks.domain.rider.entity.Rider;

import java.util.List;

public interface RiderRepository {
    Long save(RiderSaveDto member);

    Rider findById(Long memberId);

    List<Rider> findAll();

    void update(RiderUpdateDto dto);

    void delete(Rider Rider);
}
