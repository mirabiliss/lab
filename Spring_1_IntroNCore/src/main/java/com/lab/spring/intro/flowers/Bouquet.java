package com.lab.spring.intro.flowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bouquet {
    private List<Flower> flowers;

    @Autowired
    public Bouquet(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void printFlowers() {
        for (Flower f : flowers) {
            System.out.println(f.getNaming());
        }
    }
}
