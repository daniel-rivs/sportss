package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Horario;
import java.util.List;

public interface HorarioService {

    List<Horario> obtenerHorarios();

    // Método para obtener los horarios por ID de deportivo
    List<Horario> obtenerHorariosPorDeportivo(int deportivoid);

    // Método para guardar un nuevo horario
    Horario guardarHorario(Horario horario);

    // Método para eliminar un horario por su ID
    boolean eliminarHorario(Long idHorario);
}
