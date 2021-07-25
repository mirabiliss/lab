package com.lab.spring.intro;

import com.lab.spring.intro.config.Conf1;
import com.lab.spring.intro.config.Conf2;
import com.lab.spring.intro.config.FlowerConfig;
import com.lab.spring.intro.config.OtherConfig;
import com.lab.spring.intro.flowers.Bouquet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("1-4:");
        ApplicationContext ac1 = new AnnotationConfigApplicationContext(Conf1.class);
        System.out.println("~~~~~~~~~~~~~~~~ Conf1 ~~~~~~~~~~~~~~~~");
        for (String beanDefinitionName : ac1.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        ApplicationContext ac2 = new AnnotationConfigApplicationContext(Conf2.class);
        System.out.println("~~~~~~~~~~~~~~~~ Conf2 ~~~~~~~~~~~~~~~~");
        for (String beanDefinitionName : ac2.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(System.lineSeparator() + "5-6:");
        ApplicationContext otherAc = new AnnotationConfigApplicationContext(OtherConfig.class);
        System.out.println("~~~~~~~~~~~~~ OtherConfig ~~~~~~~~~~~~~");
        for (String bdn : otherAc.getBeanDefinitionNames()) {
            System.out.println(bdn);
        }

        System.out.println(System.lineSeparator() + "7-8:");
        ApplicationContext flowerAc = new AnnotationConfigApplicationContext(FlowerConfig.class);
        System.out.println(System.lineSeparator() + "~~~~~~~~~~~~~~~~ Flowers ~~~~~~~~~~~~~~~~");
        flowerAc.getBean(Bouquet.class).printFlowers();
    }
}
