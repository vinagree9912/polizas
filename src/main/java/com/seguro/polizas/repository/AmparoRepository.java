package com.seguro.polizas.repository;

import com.seguro.polizas.model.Amparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmparoRepository  extends JpaRepository<Amparo,Integer> {
}
