package com.epam.spring.core.beans;

public interface ValidatableBean {
    String message = "Invalid values assigned! " +
            "Name must be non-null, value must be a positive number!";

    void validate();
}
