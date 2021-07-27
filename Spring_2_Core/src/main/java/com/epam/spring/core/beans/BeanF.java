package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanF {
    private String name;
    private int value;

    public BeanF() {
        System.out.println("BeanF constructor");
    }

    @Value("fname")
    public void setName(String name) {
        this.name = name;
    }

    @Value("45")
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[F:" + name + "->" + value + ']';
    }
}
