package com.club.socios.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented


@Constraint(validatedBy = DniValidator.class)


@Target({ElementType.FIELD})


@Retention(RetentionPolicy.RUNTIME)


public @interface DniValido {

    String message() default "{socio.dni.invalido}";
    

    Class<?>[] groups() default {};
    

    Class<? extends Payload>[] payload() default {};
    
}
