package com.seguro.polizas.repository;

import com.seguro.polizas.model.Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaRepository extends JpaRepository<Prima, Integer> {

    List<Prima> findByCodigo(Integer codigo);
}
