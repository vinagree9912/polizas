package com.seguro.polizas.service.implementation;

import com.seguro.polizas.model.Prima;
import com.seguro.polizas.repository.PrimaRepository;
import com.seguro.polizas.service.PrimaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PrimaServiceImpl implements PrimaService {

    private final PrimaRepository primaRepository;
    @Override
    public Prima obtenerPrimaPorEdad(int codigoAmparo, int edad) {
        return primaRepository.findByCodigo(codigoAmparo).stream()
                .filter(prima -> edad >= prima.getEdadMinima() && edad <= prima.getEdadMaxima())
                .findFirst()
                .orElse(null);
    }
}
