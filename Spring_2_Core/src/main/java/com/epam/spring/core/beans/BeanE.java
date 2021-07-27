package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanE {
    private String name;
    private String value;

    public BeanE() {
        System.out.println("BeanE constructor");
    }

    @Value("ename")
    public void setName(String name) {
        this.name = name;
    }

    @Value("evalue")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[E:" + name + "->" + value + ']';
    }
}
