package com.lab.spring.intro.flowers;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Primary
public class Peony implements Flower {
    @Override
    public String getNaming() {
        return "Peony";
    }
}
