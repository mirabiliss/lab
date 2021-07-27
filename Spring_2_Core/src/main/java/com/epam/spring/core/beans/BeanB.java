package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanB {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private String value;

    public BeanB() {
        System.out.println("BeanB constructor");
    }

    @Override
    public String toString() {
        return "[B:" + name + "->" + value + ']';
    }

    private void init() {
        System.out.println(this + ".init()");
    }

    private void newInitMethod() {
        System.out.println(this + ".newInitMethod()");
    }

    private void destroy() {
        System.out.println(this + ".destroy()");
    }
}
