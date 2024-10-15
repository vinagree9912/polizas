package com.seguro.polizas.utils.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoIdentificacionEnum {
    CC(1), // Cédula de Ciudadanía
    CE(2); // Cédula de Extranjería

    private final int codigo;

    // Método para manejar la conversión desde JSON
    @JsonCreator
    public static TipoIdentificacionEnum fromValue(String value) {
        System.out.println("value " + value);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de identificación no puede estar vacío o inválido");
        }
        try {
            return TipoIdentificacionEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El tipo de identificación no es válido: " + value);
        }
    }


    // Método para convertir el enum a un valor JSON
    @JsonValue
    public String toValue() {
        return this.name();
    }
}
