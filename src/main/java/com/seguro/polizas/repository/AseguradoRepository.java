package com.seguro.polizas.repository;


import com.seguro.polizas.model.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AseguradoRepository extends JpaRepository<Asegurado, Long> {

    Optional<Asegurado>findByNumeroIdentificacion(Long numeroIdentificacion);
}
