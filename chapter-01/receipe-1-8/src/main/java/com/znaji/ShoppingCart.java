package com.znaji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        this.items.add(item);
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(this.items);
    }

}