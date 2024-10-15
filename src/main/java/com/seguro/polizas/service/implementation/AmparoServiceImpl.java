package com.seguro.polizas.service.implementation;

import com.seguro.polizas.model.Amparo;
import com.seguro.polizas.model.Prima;
import com.seguro.polizas.repository.AmparoRepository;
import com.seguro.polizas.service.AmparoService;
import com.seguro.polizas.service.PrimaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class AmparoServiceImpl implements AmparoService {

    private AmparoRepository amparoRepository;
    private PrimaService primaService;

    @Override
    public List<Amparo> obtenerAmparosAplicables(int edad) {
        return amparoRepository.findAll().stream()
                .filter(amparo -> amparoAplicaPorEdad(amparo.getCodigo(), edad))
                .collect(Collectors.toList());
    }

    private boolean amparoAplicaPorEdad(int codigoAmparo, int edad) {
        Prima prima = primaService.obtenerPrimaPorEdad(codigoAmparo, edad);
        return prima != null;
    }

}
