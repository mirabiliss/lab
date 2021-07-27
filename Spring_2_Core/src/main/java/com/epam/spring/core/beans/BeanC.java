package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanC {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private String value;

    public BeanC() {
        System.out.println("BeanC constructor");
    }

    @Override
    public String toString() {
        return "[C:" + name + "->" + value + ']';
    }

    private void init() {
        System.out.println(this + ".init()");
    }

    private void destroy() {
        System.out.println(this + ".destroy()");
    }
}
