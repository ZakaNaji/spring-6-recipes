package com.znaji;

public class ProductDoaImpl implements ProductDao {

    final private String message;

    public ProductDoaImpl(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }
}
