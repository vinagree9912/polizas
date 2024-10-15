package com.seguro.polizas.exception;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoIdentificacionValidator.class)
public @interface ValidTipoIdentificacion {
    String message() default "El tipo de identificación no puede estar vacío";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

