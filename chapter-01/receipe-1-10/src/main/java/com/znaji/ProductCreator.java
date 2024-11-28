package com.znaji;

public class ProductCreator {

    public static Product createProduct(String productId) {
        return switch (productId) {
            case "aaa" -> new Battery("AAA", 2.5, true);
            case "aa" -> new Battery("AA", 1.5, false);
            case "cdrw" -> new Disc("CD-RW", 1.5, 700);
            case "dvdrw" -> new Disc("DVD-RW", 3.0, 4000);
            default -> throw new IllegalArgumentException("Unknown product");
        };
    }
}
