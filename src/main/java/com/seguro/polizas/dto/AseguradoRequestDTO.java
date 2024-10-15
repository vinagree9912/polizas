package com.seguro.polizas.dto;



import com.seguro.polizas.exception.ValidTipoIdentificacion;
import com.seguro.polizas.utils.enums.TipoIdentificacionEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AseguradoRequestDTO {

    @ValidTipoIdentificacion
    private TipoIdentificacionEnum tipoIdentificacion;

    @Min(value = 1, message = "El número de identificación debe ser mayor que 0")
    private Long numeroIdentificacion;

    @NotNull(message = "El valor asegurado no puede estar vacío")
    @Positive(message = "El valor asegurado debe ser mayor que cero")
    private BigDecimal valorAsegurado;
}
