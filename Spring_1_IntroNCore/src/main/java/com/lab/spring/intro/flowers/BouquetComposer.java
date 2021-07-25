package com.lab.spring.intro.flowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BouquetComposer {
    @Autowired
    public void compose(Flower a, @Qualifier("secondary") Flower b,
                        @Qualifier("alternate") Flower c) {
        System.out.println("Best priority order: " + a.getNaming()
                + ", " + b.getNaming() + ", " + c.getNaming());
    }
}
