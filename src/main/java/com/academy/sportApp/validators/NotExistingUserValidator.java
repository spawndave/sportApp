package com.academy.sportApp.validators;

import com.academy.sportApp.dto.NewUserDto;
import com.academy.sportApp.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotExistingUserValidator implements ConstraintValidator<NotUniqUsernameAndEmail, NewUserDto> {
    private final UserService userService;

    public void initialize(NotUniqUsernameAndEmail constraint) {

    }
    public boolean isValid(NewUserDto userDto,
                           ConstraintValidatorContext context) {
        if (!userDto.getEmail().isEmpty() && userService.userWithEmailExists(userDto.getEmail())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User with this email is already exist")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        if (!userDto.getUsername().isEmpty() && userService.userWithUsernameExists(userDto.getUsername())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User with this username is already exist")
                    .addPropertyNode("username").addConstraintViolation();
            return false;
        }
        return true;
    }
}