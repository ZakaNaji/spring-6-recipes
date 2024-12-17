package com.znaji.beanwrraper;

import java.util.Date;

public class Company {
    private String name;
    private Employee managingDirector;

    private Date dateCreated;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    //include the managingDirector in the toString() method
    public String toString() {
        return "Company [name=" + name + ", managingDirector=" + managingDirector + ", dateCreated=" + dateCreated + "]";
    }
}
