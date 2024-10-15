package com.seguro.polizas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiquidacionAmparoDTO {
    private Integer codigoAmparo;
    private String nombreAmparo;
    private BigDecimal valorPrima;
}
