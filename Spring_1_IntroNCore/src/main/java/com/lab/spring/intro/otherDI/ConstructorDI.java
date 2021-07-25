package com.lab.spring.intro.otherDI;

import com.lab.spring.intro.otherBeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorDI {
    private OtherBeanA otherBeanA;

    @Autowired
    public ConstructorDI (@Qualifier("obeanA") OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }
}
