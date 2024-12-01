package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByIdDeportivo(int deportivoid);
}



