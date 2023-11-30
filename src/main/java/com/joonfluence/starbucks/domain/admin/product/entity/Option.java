package com.joonfluence.starbucks.domain.admin.product.entity;

import jakarta.persistence.*;

@Table(name = "Options")
@Entity
public class Option {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int optionPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_item_id")
    private OptionItem optionItem;
}
