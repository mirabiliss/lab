package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanC implements ValidatableBean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

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

    @Override
    public void validate() {
        if (name == null || value < 0)
            throw new IllegalArgumentException(ValidatableBean.message);
    }

    private void destroy() {
        System.out.println(this + ".destroy()");
    }
}
