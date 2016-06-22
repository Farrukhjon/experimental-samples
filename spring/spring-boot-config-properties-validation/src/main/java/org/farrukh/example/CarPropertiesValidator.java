package org.farrukh.example;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CarPropertiesValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return clazz == CarProperties.class;
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "manufacturer", "manufacturer.empty");
        ValidationUtils.rejectIfEmpty(errors, "seatCount", "seatCount.empty");
        CarProperties car = (CarProperties) target;
        if(car.getSeatCount() < 1 || car.getSeatCount() > 4) {
            errors.rejectValue("seatCount", "Invalid seat count");
        }
    }

}
