package com.joonfluence.starbucks.domain.admin.product.entity;

import com.joonfluence.starbucks.domain.admin.product.enums.ProductStatus;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductType;
import com.joonfluence.starbucks.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @OneToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;

    @Builder
    public Product(String description, ProductStatus productStatus, ProductType productType, ProductPrice productPrice, Category category, Option option) {
        this.description = description;
        this.productStatus = productStatus;
        this.productType = productType;
        this.productPrice = productPrice;
        this.category = category;
        this.option = option;
    }

}
