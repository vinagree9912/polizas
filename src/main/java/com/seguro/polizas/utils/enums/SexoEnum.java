package com.seguro.polizas.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SexoEnum {
    MASCULINO(1), // MASCULINO
    FEMENINO(2); // FEMENINO
    private final int codigo;
}
