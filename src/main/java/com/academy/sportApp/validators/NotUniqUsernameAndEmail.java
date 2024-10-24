package com.academy.sportApp.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingUserValidator.class)
public @interface NotUniqUsernameAndEmail {
    String message() default "User with this email is already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}