package com.academy.sportApp.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingUserValidator.class)
public @interface NotExistingUser {
    String message() default "User with this username is already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}