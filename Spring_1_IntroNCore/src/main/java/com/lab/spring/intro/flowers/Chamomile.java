package com.lab.spring.intro.flowers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Qualifier("secondary")
public class Chamomile implements Flower {
    @Override
    public String getNaming() {
        return "Chamomile";
    }
}
