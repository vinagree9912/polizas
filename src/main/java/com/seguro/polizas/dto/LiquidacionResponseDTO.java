package com.seguro.polizas.dto;

import com.seguro.polizas.utils.enums.TipoIdentificacionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiquidacionResponseDTO {
    private TipoIdentificacionEnum tipoIdentificacion;
    private Long numeroIdentificacion;
    private BigDecimal valorAsegurado;
    private List<LiquidacionAmparoDTO> liquidacion;
    private BigDecimal valorTotal;
}