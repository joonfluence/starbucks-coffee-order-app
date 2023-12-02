package com.joonfluence.starbucks.domain.rider.repository;

import com.joonfluence.starbucks.domain.rider.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {}
