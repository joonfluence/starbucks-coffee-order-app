package com.joonfluence.starbucks.domain.user.customer.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
