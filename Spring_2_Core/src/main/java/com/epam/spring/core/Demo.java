package com.epam.spring.core;

import com.epam.spring.core.config.Config1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        System.out.println(System.lineSeparator() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                + System.lineSeparator() + "\tApplication context is ready" + System.lineSeparator()
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + System.lineSeparator());

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println(System.lineSeparator() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                + System.lineSeparator() + "\tClosing application context" + System.lineSeparator()
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + System.lineSeparator());

        context.close();
    }
}
