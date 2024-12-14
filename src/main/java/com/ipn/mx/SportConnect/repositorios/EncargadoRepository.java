package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Integer> {
    Optional<Encargado> findByRfcCurp(String rfcCurp); //Debe ser RfcCurp en lugar de rfcCurp
}