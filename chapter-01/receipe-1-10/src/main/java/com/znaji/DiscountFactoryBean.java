package com.znaji;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

    private double discount;
    private Product product;

    public DiscountFactoryBean() {
        System.out.println("DiscountFactoryBean -> constructor");
    }

    @Override
    public Class<?> getObjectType() {
        return product.getClass();
    }

    @Override
    protected Product createInstance() throws Exception {
        System.out.println("DiscountFactoryBean -> createInstance");
        product.setPrice(product.getPrice() * (1 - discount));
        return product;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
