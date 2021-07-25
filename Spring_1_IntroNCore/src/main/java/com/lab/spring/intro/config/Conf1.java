package com.lab.spring.intro.config;

import com.lab.spring.intro.beans1.BeanA;
import com.lab.spring.intro.beans1.BeanB;
import com.lab.spring.intro.beans1.BeanC;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BeanA.class, BeanB.class, BeanC.class})
public class Conf1 {
}
