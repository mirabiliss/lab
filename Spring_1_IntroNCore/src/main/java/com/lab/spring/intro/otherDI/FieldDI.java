package com.lab.spring.intro.otherDI;

import com.lab.spring.intro.otherBeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldDI {
    @Autowired
    private OtherBeanC otherBeanC;
}
