package com.joonfluence.starbucks.domain.user.customer.entity;

import com.joonfluence.starbucks.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

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
    private String nickName;

    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean pushNotificationOn;
    private Boolean locationServiceAgree;

    // Order order;
    // Delivery delivery;

    public void update(Customer customer){
        this.nickName = customer.getNickName();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.pushNotificationOn = customer.getPushNotificationOn();
        this.locationServiceAgree = customer.getLocationServiceAgree();
    }

    public void updateName(String nickName){
        this.nickName = nickName;
    }

    public void updateEmail(String email){
        this.email = email;
    }
    
    public void updatePassword(String password){
        this.password = password;
    }
}
