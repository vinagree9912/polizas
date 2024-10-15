package com.seguro.polizas.service.implementation;


import com.seguro.polizas.dto.AseguradoRequestDTO;
import com.seguro.polizas.dto.LiquidacionAmparoDTO;
import com.seguro.polizas.dto.LiquidacionResponseDTO;
import com.seguro.polizas.exception.AseguradoNotFoundException;
import com.seguro.polizas.model.Amparo;
import com.seguro.polizas.model.Asegurado;
import com.seguro.polizas.model.Prima;
import com.seguro.polizas.repository.AseguradoRepository;
import com.seguro.polizas.service.AmparoService;
import com.seguro.polizas.service.AseguradoService;
import com.seguro.polizas.service.PrimaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AseguradoServiceImpl implements AseguradoService {

    private static final Logger logger = LoggerFactory.getLogger(AseguradoServiceImpl.class);

    private AseguradoRepository aseguradoRepository;
    private AmparoService amparoService;
    private PrimaService primaService;
    @Override
    public LiquidacionResponseDTO calcularLiquidacion(AseguradoRequestDTO aseguradoDto) {
        Optional<Asegurado> aseguradoOptional = aseguradoRepository.findByNumeroIdentificacion(aseguradoDto.getNumeroIdentificacion());
        // Si el asegurado no se encuentra, lanza una excepción
        Asegurado asegurado = aseguradoOptional.orElseThrow(() ->
                new AseguradoNotFoundException("Asegurado no encontrado con número de identificación "
                        + aseguradoDto.getNumeroIdentificacion()
                        + " y tipo de identificación "
                        + aseguradoDto.getTipoIdentificacion())
        );

        // Calcular la edad del asegurado
        int edad = calcularEdad(asegurado.getFechaNacimiento());

        logger.info("La edad del asegurado con ID {} es {} años.", asegurado.getId(), edad);
        // Obtener los amparos aplicables según la edad
        List<Amparo> amparosAplicables = amparoService.obtenerAmparosAplicables(edad);

        // Inicializar la liquidación
        LiquidacionResponseDTO liquidacionResponse = new LiquidacionResponseDTO();
        liquidacionResponse.setTipoIdentificacion(aseguradoDto.getTipoIdentificacion());
        liquidacionResponse.setNumeroIdentificacion(aseguradoDto.getNumeroIdentificacion());
        liquidacionResponse.setValorAsegurado(aseguradoDto.getValorAsegurado());

        List<LiquidacionAmparoDTO> liquidacionAmparos = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO; // Inicializa en 0

        // Procesar cada amparo aplicable
        for (Amparo amparo : amparosAplicables) {
            Prima prima = primaService.obtenerPrimaPorEdad(amparo.getCodigo(), edad);

            // Si se encuentra una prima, calcular el valor y agregarlo a la liquidación
            if (prima != null) {
                BigDecimal valorPrima = aseguradoDto.getValorAsegurado().multiply(prima.getPorcentajePrima());
                valorTotal = valorTotal.add(valorPrima);

                LiquidacionAmparoDTO liquidacionAmparo = new LiquidacionAmparoDTO();
                liquidacionAmparo.setCodigoAmparo(amparo.getCodigo());
                liquidacionAmparo.setNombreAmparo(amparo.getNombre());
                liquidacionAmparo.setValorPrima(valorPrima);

                liquidacionAmparos.add(liquidacionAmparo);
            }
        }

        // Setear los amparos y el valor total calculado
        liquidacionResponse.setLiquidacion(liquidacionAmparos);
        liquidacionResponse.setValorTotal(valorTotal);

        // Registrar la liquidación calculada
        log.info("Liquidación calculada: {}", liquidacionResponse);

        return liquidacionResponse;
    }


    private int calcularEdad(LocalDate fechaNacimiento) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular la diferencia entre la fecha de nacimiento y la fecha actual
        if (fechaNacimiento != null) {
            return Period.between(fechaNacimiento, fechaActual).getYears();
        } else {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
    }

}
