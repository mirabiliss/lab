package com.lab.spring.intro.config;

import com.lab.spring.intro.beans3.BeanD;
import com.lab.spring.intro.beans3.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.lab.spring.intro.beans2")
public class Conf2 {
    @Bean
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanF beanF() {
        return new BeanF();
    }
}
