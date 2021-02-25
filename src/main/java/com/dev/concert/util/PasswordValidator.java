package com.dev.concert.util;

import com.dev.concert.annotaion.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object user, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(user)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(user)
                .getPropertyValue(fieldMatch);

        if (String.valueOf(fieldValue).isEmpty() || fieldValue == null) {
            return false;
        }
        return fieldValue.equals(fieldMatchValue);
    }
}
