package com.epam.spring.web.mvc.electives.exception;

import com.epam.spring.web.mvc.electives.model.enums.ErrorType;

public class UserNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "User was not found!";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }

}
