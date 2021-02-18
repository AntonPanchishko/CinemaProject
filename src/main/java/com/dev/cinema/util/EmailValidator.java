package com.dev.cinema.util;

import com.dev.cinema.annotaion.EmailValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    private static final String EMAIL_VALID_FORMAT = "\\w+@[a-z]+\\.[a-z]+";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(EMAIL_VALID_FORMAT);
    }
}
