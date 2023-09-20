package com.bassure.spring.basics.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomAgeAnnotation implements ConstraintValidator<Age, Integer> {

    private Integer minimum;
    private Integer maximum;

    @Override
    public void initialize(Age age) {
        System.out.println(">>>>>>>>>>>intialize()<<<<<<<<<<<<<<");
        System.out.println(minimum = age.minimumAge());
        System.out.println(maximum = age.maximumAge());

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext cvc) {

        if (value != null && value >= minimum && value <= maximum) {
            return true;
        }

        return false;

    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

}
