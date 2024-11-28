package com.znaji;

import java.util.Map;

public class ProductInstanceFactory {

    final private Map<String, Product> products;

    public ProductInstanceFactory(Map<String, Product> products) {
        this.products = products;
    }

    public Product createProduct(String productId) {
        var product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Unknown product");
        }
        return product;
    }
}
