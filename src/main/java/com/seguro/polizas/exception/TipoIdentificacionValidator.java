package com.seguro.polizas.exception;

import com.seguro.polizas.utils.enums.TipoIdentificacionEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class TipoIdentificacionValidator implements ConstraintValidator<ValidTipoIdentificacion, TipoIdentificacionEnum> {
    @Override
    public boolean isValid(TipoIdentificacionEnum value, ConstraintValidatorContext context) {
        return value != null;
    }
}

