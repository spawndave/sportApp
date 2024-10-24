package com.academy.sportApp.validators;

import com.academy.sportApp.dto.TrainingDto;
import com.academy.sportApp.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class NotCorrectTrainingDateValidator implements ConstraintValidator<NotCorrectTrainingDate, TrainingDto> {
    private final UserService userService;

    public void initialize(NotCorrectTrainingDate constraint) {

    }
    public boolean isValid(TrainingDto trainingDto,
                           ConstraintValidatorContext context) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(trainingDto.getDate())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Check the training date")
                    .addPropertyNode("date").addConstraintViolation();
            return false;
        }

        return true;
    }
}