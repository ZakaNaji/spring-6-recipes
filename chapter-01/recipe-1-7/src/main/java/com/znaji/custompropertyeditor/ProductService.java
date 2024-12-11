package com.znaji.custompropertyeditor;

import com.znaji.Disc;
import com.znaji.Product;

public class ProductService {

    final Disc disc;

    public ProductService(Disc disc) {
        this.disc = disc;
    }

    public void displayProduct() {
        System.out.println(disc);
    }
}
