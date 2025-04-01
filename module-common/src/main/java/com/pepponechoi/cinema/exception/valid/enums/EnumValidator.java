package com.pepponechoi.cinema.exception.valid.enums;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<EnumValid, String> {

    private EnumValid annotation;
    public static final String message = "Must match one of Enums";

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (annotation.message().equals(message)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                message.replace("enums",
                    Arrays.stream(annotation.target().getEnumConstants()).toList().toString()))
                .addConstraintViolation();
        }

        if (s == null || s.trim().isEmpty()) return annotation.nullable();
        return Arrays.stream(annotation.target().getEnumConstants()).anyMatch(e -> e.name().equals(s));
    }
}
