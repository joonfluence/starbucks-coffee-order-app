package com.joonfluence.starbucks.domain.user.customer.entity;

import com.joonfluence.starbucks.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    public void updateName(Customer customer){
        this.name = customer.getName();
    }

    public void updateEmail(Customer customer){
        this.email = customer.getEmail();
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
