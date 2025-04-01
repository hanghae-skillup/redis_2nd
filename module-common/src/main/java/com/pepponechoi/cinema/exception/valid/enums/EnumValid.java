package com.pepponechoi.cinema.exception.valid.enums;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = EnumValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValid {
    Class<? extends Enum<?>> target();
    boolean nullable() default false;
    String message() default EnumValidator.message;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
