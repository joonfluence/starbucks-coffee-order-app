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
<<<<<<< HEAD
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
=======
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    public void updateName(Customer customer){
        this.name = customer.getName();
>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
    }

    public void updateEmail(Customer customer){
        this.email = customer.getEmail();
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
