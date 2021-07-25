package com.lab.spring.intro.flowers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Qualifier("alternate")
public class Rose implements Flower {
    @Override
    public String getNaming() {
        return "Rose";
    }
}
