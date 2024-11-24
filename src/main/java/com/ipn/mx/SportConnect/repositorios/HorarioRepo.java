package com.miempresa.proyectospring.repository;

import com.miempresa.proyectospring.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepo extends JpaRepository<Horario, Long> {
    List<Horario> findByIdDeportivo(String idDeportivo);
}



