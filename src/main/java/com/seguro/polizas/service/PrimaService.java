package com.seguro.polizas.service;

import com.seguro.polizas.model.Prima;

public interface PrimaService {
    Prima obtenerPrimaPorEdad(int codigoAmparo, int edad);
}
