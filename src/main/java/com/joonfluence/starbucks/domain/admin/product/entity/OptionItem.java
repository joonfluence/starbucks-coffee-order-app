package com.joonfluence.starbucks.domain.admin.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OptionItem {
    @Id @GeneratedValue
    private Long id;
}
