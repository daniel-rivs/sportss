package com.miempresa.proyectospring.service;

import com.miempresa.proyectospring.model.Horario;

import java.util.List;

public interface HorarioServiceI {

    // Método para obtener los horarios por ID de deportivo
    List<Horario> obtenerHorariosPorDeportivo(String idDeportivo);

    // Método para guardar un nuevo horario
    Horario guardarHorario(Horario horario);

    // Método para actualizar un horario
    void updateHorario(Horario horario);

    // Método para eliminar un horario por su ID
    void eliminarHorario(Long idHorario);
}
