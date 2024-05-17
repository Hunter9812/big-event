package com.example.anno;

import com.example.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StateValidation.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "state参数的值只能是已发布或草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}