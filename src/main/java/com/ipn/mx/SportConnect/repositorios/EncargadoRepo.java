package com.miempresa.proyectospring.repository;

import com.miempresa.proyectospring.model.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EncargadoRepo extends JpaRepository<Encargado, Long> {
    Optional<Encargado> findByRfcCurp(String rfcCurp); // Asegúrate de usar "rfcCurp" en lugar de "RFC_CURP"
}