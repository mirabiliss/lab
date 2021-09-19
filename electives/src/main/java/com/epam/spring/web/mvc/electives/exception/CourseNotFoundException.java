package com.epam.spring.web.mvc.electives.exception;

import com.epam.spring.web.mvc.electives.model.enums.ErrorType;

public class CourseNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Course was not found!";

    public CourseNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }

}
