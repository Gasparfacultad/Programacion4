package com.club.socios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DniValidator implements ConstraintValidator<DniValido, String> {
    

    @Override
    public boolean isValid(String dni, ConstraintValidatorContext context) {
        

        if (dni == null) {
            return false;
            
        }

        return dni.matches("\\d{7,8}");
        
    }
}
