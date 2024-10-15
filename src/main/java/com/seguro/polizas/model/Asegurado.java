package com.seguro.polizas.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.seguro.polizas.utils.enums.SexoEnum;
import com.seguro.polizas.utils.enums.TipoIdentificacionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asegurados")
public class Asegurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoIdentificacionEnum tipoIdentificacion;// 1: CC, 2: CE

    private Long numeroIdentificacion;
    private String apellidos;
    private String nombres;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo; // 1: Masculino, 2: Femenino

    private LocalDate fechaNacimiento;

}