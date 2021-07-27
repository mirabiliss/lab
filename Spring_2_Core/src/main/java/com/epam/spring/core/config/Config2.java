package com.epam.spring.core.config;

import com.epam.spring.core.beans.BeanA;
import com.epam.spring.core.beans.BeanE;
import com.epam.spring.core.beans.BeanF;
import com.epam.spring.core.beans.MyBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackageClasses = {MyBeanFactoryPostProcessor.class})
public class Config2 {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}
