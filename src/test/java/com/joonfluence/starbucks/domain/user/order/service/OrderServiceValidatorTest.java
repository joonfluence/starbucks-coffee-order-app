package com.joonfluence.starbucks.domain.user.order.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.entity.ProductPrice;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductStatus;
import com.joonfluence.starbucks.domain.admin.product.enums.ProductType;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class OrderServiceValidatorTest {
    @Mock
    ProductRepository productRepository;
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    OrderServiceValidator orderServiceValidator;
    private Customer testCustomer;
    private Product testProduct;
    private Product testProduct2;
    private List<Long> testProductIds;
    private ProductPrice testProductPrice;
    @BeforeEach
    void init(){
        testProductPrice = ProductPrice.builder().price(10000L).build();
        testProduct = Product.builder().id(1L).name("아메리카노").productStatus(ProductStatus.ON_SALE).productType(ProductType.COFFEE).productPrice(testProductPrice).build();
        testProduct2 = Product.builder().id(1L).name("아메리카노").productStatus(ProductStatus.ON_SALE).productType(ProductType.COFFEE).productPrice(testProductPrice).build();
        testCustomer = Customer.builder().id(1L).nickName("Joonho").email("joonfluence.dev@gmail.com").password("!@#gmlfkr7236").build();
        testProductIds = List.of(testProduct.getId(), testProduct2.getId());
    }

    @Test
    void validateCustomer() {

    }

    @Test
    void validateProducts() {
        // given
        when(productRepository.findById(Mockito.any(Long.class))).thenThrow(NoSuchProductException.class);

        // when & then
        Assertions.assertThrows(NoSuchProductException.class, () -> orderServiceValidator.validateProducts(testProductIds));
    }
}