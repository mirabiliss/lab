package com.lab.spring.intro.otherBeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("obeanA")
public class OtherBeanA {
}
