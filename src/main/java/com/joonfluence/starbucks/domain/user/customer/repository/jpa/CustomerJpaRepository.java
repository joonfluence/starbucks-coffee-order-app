package com.joonfluence.starbucks.domain.user.customer.repository.jpa;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.dto.CustomerSaveDto;
import com.joonfluence.starbucks.domain.user.customer.dto.CustomerUpdateDto;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CustomerJpaRepository implements CustomerRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(CustomerSaveDto dto) {
        Customer customer = Customer.builder().name(dto.getName()).build();
        em.persist(customer);
        return customer.getId();
    }

    @Override
    public Customer findById(Long memberId) {
        return em.find(Customer.class, memberId);
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select m from Member m", Customer.class).getResultList();
    }

    @Override
    public void update(CustomerUpdateDto dto) {
        Customer customer = Customer.builder().id(dto.getId()).name(dto.getName()).build();
        customer.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        em.remove(customer);
    }
}