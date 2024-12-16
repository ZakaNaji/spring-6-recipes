package com.znaji.beanwrraper;

public class ExoticType {

    private String name;

    public ExoticType() {
    }

    public ExoticType(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExoticType [name=" + name + "]";
    }
}
