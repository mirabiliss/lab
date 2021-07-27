package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanF {
    private String name;
    private String value;

    public BeanF() {
        System.out.println("BeanF constructor");
    }

    @Value("fname")
    public void setName(String name) {
        this.name = name;
    }

    @Value("fvalue")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[F:" + name + "->" + value + ']';
    }
}
