package com.epam.spring.core.config;

import com.epam.spring.core.beans.BeanB;
import com.epam.spring.core.beans.BeanC;
import com.epam.spring.core.beans.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import({Config2.class})
@PropertySource("classpath:application.properties")
public class Config1 {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD() {
        return new BeanD();
    }

}
