package com.znaji.beanwrraper;

public class Company {
    private String name;
    private Employee managingDirector;

    public Company() {
    }

    public Employee getManagingDirector() {
        return managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    //include the managingDirector in the toString() method
    public String toString() {
        return "Company [name=" + name + ", managingDirector=" + managingDirector + "]";
    }
}
