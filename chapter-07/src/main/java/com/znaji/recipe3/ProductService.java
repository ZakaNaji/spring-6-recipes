package com.znaji.recipe3;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional()
    public void addTenProducts() {
        for (int i =1; i < 10; i++) {
            productRepository.addProduct("Product"+i, i*100);
            if (i == 5 ) throw new RuntimeException(";)");
        }
    }

}
