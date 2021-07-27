package com.epam.spring.core.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class BeanA implements InitializingBean, DisposableBean, ValidatableBean {
    private String name;
    private int value;

    public BeanA() {
        System.out.println("BeanA constructor");
    }

    @Value("aname")
    public void setName(String name) {
        this.name = name;
    }

    @Value("73")
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[A:" + name + "->" + value + ']';
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(this + ".afterPropertiesSet()");
    }

    @Override
    public void validate() {
        if (name == null || value < 0)
            throw new IllegalArgumentException(ValidatableBean.message);
    }

    @Override
    public void destroy() {
        System.out.println(this + ".destroy()");
    }
}
