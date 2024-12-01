package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {
    Optional<Encargado> findByRfcCurp(String rfcCurp); // Asegúrate de usar "rfcCurp" en lugar de "RFC_CURP"
}