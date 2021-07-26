package com.lab.spring.intro.config;

import com.lab.spring.intro.beans3.BeanE;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.lab.spring.intro.beans2", "com.lab.spring.intro.beans3"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanE.class))
public class Conf2 {
}
