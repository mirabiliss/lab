package com.lab.spring.intro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.lab.spring.intro.otherBeans", "com.lab.spring.intro.otherDI"})
public class OtherConfig {
}
