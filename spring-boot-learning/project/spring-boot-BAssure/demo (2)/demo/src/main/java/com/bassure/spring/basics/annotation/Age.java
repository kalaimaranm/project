package com.bassure.spring.basics.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  
@Constraint(validatedBy = CustomAgeAnnotation.class)
public @interface Age {

    String message() default "{age must be minimum 18 and maximum 48}";

    int minimumAge() default 18;

    int maximumAge() default 48;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
