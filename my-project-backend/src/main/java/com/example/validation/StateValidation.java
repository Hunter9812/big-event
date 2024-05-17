package com.example.validation;

import com.example.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return value.equals("已发布") || value.equals("草稿");
    }
}
