package com.academy.sportApp.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotCorrectTrainingDateValidator.class)
public @interface NotCorrectTrainingDate {
    String message() default "Date in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}