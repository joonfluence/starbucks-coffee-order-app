package com.joonfluence.starbucks.domain.admin.product.service;

import com.joonfluence.starbucks.domain.admin.product.entity.Product;
import com.joonfluence.starbucks.domain.admin.product.exception.NoSuchProductException;
import com.joonfluence.starbucks.domain.admin.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchProductException("해당 상품이 존재하지 않습니다."));
    }
}
