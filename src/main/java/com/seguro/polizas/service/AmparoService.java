package com.seguro.polizas.service;

import com.seguro.polizas.model.Amparo;

import java.util.List;

public interface AmparoService {
    List<Amparo> obtenerAmparosAplicables(int edad);
}
