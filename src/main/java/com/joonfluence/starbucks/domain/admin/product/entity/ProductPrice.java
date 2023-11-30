package com.joonfluence.starbucks.domain.admin.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductPrice {
    @Id
    @GeneratedValue
    @Column(name = "product_price_id")
    private Long id;

    @Column(name = "product_price")
    private Long price;
}
