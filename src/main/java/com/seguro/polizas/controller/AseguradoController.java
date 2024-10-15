package com.seguro.polizas.controller;


import com.seguro.polizas.dto.AseguradoRequestDTO;
import com.seguro.polizas.dto.LiquidacionResponseDTO;
import com.seguro.polizas.service.AseguradoService;
import com.seguro.polizas.utils.Constantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(Constantes.PATH_ASEGURADOS)
@AllArgsConstructor
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.OPTIONS})
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Api(tags = Constantes.PATH_ASEGURADOS)
public class AseguradoController {
    private AseguradoService aseguradoService;

    @PostMapping(Constantes.PATH_LIQUIDACION)
    @ApiOperation(value = "Calcular liquidación del asegurado", response = LiquidacionResponseDTO.class)
    public ResponseEntity<LiquidacionResponseDTO> calcularLiquidacion(@Valid @RequestBody AseguradoRequestDTO aseguradoDto) {
        LiquidacionResponseDTO liquidacion = aseguradoService.calcularLiquidacion(aseguradoDto);
        return ResponseEntity.ok(liquidacion);
    }
}
