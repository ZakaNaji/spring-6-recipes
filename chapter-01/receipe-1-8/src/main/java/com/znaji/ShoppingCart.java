package com.znaji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    public ShoppingCart() {
        System.out.println("ShoppingCart instance created number: " + new java.util.Random().nextInt());
    }

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        this.items.add(item);
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }

}