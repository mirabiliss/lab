package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanD {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public BeanD() {
        System.out.println("BeanD constructor");
    }

    @Override
    public String toString() {
        return "[D:" + name + "->" + value + ']';
    }

    private void init() {
        System.out.println(this + ".init()");
    }

    private void destroy() {
        System.out.println(this + ".destroy()");
    }
}
