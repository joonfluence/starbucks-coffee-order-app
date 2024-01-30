package com.joonfluence.starbucks.domain.user.customer.entity;

public enum UserType {
    Customer("고객"),
    Employee("직원");

    String name;

    UserType(String name) {
        this.name = name;
    }
}
