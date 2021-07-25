package com.lab.spring.intro.otherDI;

import com.lab.spring.intro.otherBeans.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SetterDI {
    private OtherBeanB otherBeanB;

    @Autowired
    public void setOtherBeanB(@Qualifier("otherBeanB") OtherBeanB myBean) {
        this.otherBeanB = myBean;
    }
}
