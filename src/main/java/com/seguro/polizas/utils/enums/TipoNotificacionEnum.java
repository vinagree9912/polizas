package com.seguro.polizas.utils.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum TipoNotificacionEnum {
    EMAIL("Email"),
    SMS("SMS");

    private final String descripcion;

}
