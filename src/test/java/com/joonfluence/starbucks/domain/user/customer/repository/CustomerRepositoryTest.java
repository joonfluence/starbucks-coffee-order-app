package com.joonfluence.starbucks.domain.user.customer.repository;

import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
=======
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.dao.DataIntegrityViolationException;
>>>>>>> e15a14e (test(Auth) : Customer Repository 테스트)

=======
>>>>>>> b7fd1df (fix(Auth) : Customer Repository 테스트)
import java.util.NoSuchElementException;

@DataJpaTest
<<<<<<< HEAD
@ActiveProfiles("test")
=======
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
>>>>>>> e15a14e (test(Auth) : Customer Repository 테스트)
=======
=======
>>>>>>> 6167229 (test(Auth) : Customer Repository 테스트)
=======
>>>>>>> c7ac17d (feat(Auth) : Redis에 RefreshToken 정보 저장)
import org.springframework.test.context.ActiveProfiles;
=======
import org.springframework.dao.DataIntegrityViolationException;
>>>>>>> 3df7dc8 (test(Auth) : Customer Repository 테스트)
=======
import org.springframework.test.context.ActiveProfiles;
>>>>>>> c8aa812 (feat(Auth) : Redis에 RefreshToken 정보 저장)

import java.util.NoSuchElementException;

@DataJpaTest
<<<<<<< HEAD
<<<<<<< HEAD
@ActiveProfiles("test")
<<<<<<< HEAD
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
=======
=======
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
>>>>>>> 3df7dc8 (test(Auth) : Customer Repository 테스트)
<<<<<<< HEAD
>>>>>>> 6167229 (test(Auth) : Customer Repository 테스트)
=======
=======
@ActiveProfiles("test")
>>>>>>> c8aa812 (feat(Auth) : Redis에 RefreshToken 정보 저장)
>>>>>>> c7ac17d (feat(Auth) : Redis에 RefreshToken 정보 저장)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;
    private static Customer dbInsertedUser;
    private static Customer newUserRequest;

    @BeforeAll
    public static void init(){
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 6167229 (test(Auth) : Customer Repository 테스트)
=======
>>>>>>> 48c3088 (fix(Auth) : Customer Repository 테스트 (2))
        Double random = Math.random();
        String userId = "joonluence.dev" + random.toString() + "@gmail.com";
        dbInsertedUser = Customer.builder().name("Junho").email(userId).password("12341234").build();
=======
        dbInsertedUser = Customer.builder().name("Junho").email("joonfluence.dev@gmail.com").password("12341234").build();
<<<<<<< HEAD
>>>>>>> e15a14e (test(Auth) : Customer Repository 테스트)
=======
        Double random = Math.random();
        String userId = "joonluence.dev" + random.toString() + "@gmail.com";
        dbInsertedUser = Customer.builder().name("Junho").email(userId).password("12341234").build();
>>>>>>> 2ed1c99 (fix(Auth) : Customer Repository 테스트 (2))
=======
>>>>>>> 3df7dc8 (test(Auth) : Customer Repository 테스트)
<<<<<<< HEAD
>>>>>>> 6167229 (test(Auth) : Customer Repository 테스트)
=======
=======
        Double random = Math.random();
        String userId = "joonluence.dev" + random.toString() + "@gmail.com";
        dbInsertedUser = Customer.builder().name("Junho").email(userId).password("12341234").build();
>>>>>>> 35f57cc (fix(Auth) : Customer Repository 테스트 (2))
>>>>>>> 48c3088 (fix(Auth) : Customer Repository 테스트 (2))
        newUserRequest = Customer.builder().name("Junho").email("joonfluence.dev2@gmail.com").password("12341234").build();
    }

    @BeforeEach
    public void save(){
        repository.save(dbInsertedUser);
    }

    @DisplayName("1. repository의 Save 메서드 호출 시, 정상적으로 저장되어야 한다.")
    @Test
    void test_1(){
        // given & when
        Customer saved = repository.save(newUserRequest);

        // then
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getName(), newUserRequest.getName());
        Assertions.assertEquals(saved.getPassword(), newUserRequest.getPassword());
    }

    @DisplayName("2. repository의 findById 호출 시, 정상적으로 호출되어야 한다.")
    @Test
    void test_2(){
        // given & when
        Customer foundCustomer = repository.findById(dbInsertedUser.getId()).orElseThrow(() -> new NoSuchElementException("존재하지 않습니다"));
        // then
        Assertions.assertEquals(foundCustomer.getName(), dbInsertedUser.getName());
        Assertions.assertEquals(foundCustomer.getPassword(), dbInsertedUser.getPassword());
    }
}