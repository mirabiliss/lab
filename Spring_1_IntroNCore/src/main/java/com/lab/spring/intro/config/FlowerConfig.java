package com.lab.spring.intro.config;

import com.lab.spring.intro.flowers.Flower;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Flower.class})
public class FlowerConfig {
}
