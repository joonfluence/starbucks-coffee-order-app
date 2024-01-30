package com.joonfluence.starbucks.domain.admin.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OptionItem {
    @Id
    @GeneratedValue
    @Column(name = "option_item_id")
    private Long id;
    private String name;
}
