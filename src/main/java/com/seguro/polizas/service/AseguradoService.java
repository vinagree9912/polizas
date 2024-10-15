package com.seguro.polizas.service;

import com.seguro.polizas.dto.AseguradoRequestDTO;
import com.seguro.polizas.dto.LiquidacionResponseDTO;

public interface AseguradoService {
    LiquidacionResponseDTO calcularLiquidacion(AseguradoRequestDTO aseguradoDto);
}
