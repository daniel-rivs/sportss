package com.miempresa.proyectospring.service;

import com.miempresa.proyectospring.model.Horario;
import com.miempresa.proyectospring.repository.HorarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta clase como un componente de servicio en Spring.
public class HorarioService {

    @Autowired // Inyecta la dependencia del repositorio de Horarios.
    private HorarioRepo horarioRepository;

    /**
     * Obtiene todos los horarios asociados a un deportivo específico.
     *
     * @param idDeportivo El ID del deportivo.
     * @return Una lista de horarios.
     */
    public List<Horario> obtenerHorariosPorDeportivo(String idDeportivo) {
        return horarioRepository.findByIdDeportivo(idDeportivo);
    }

    /**
     * Guarda un nuevo horario o actualiza uno existente.
     *
     * @param horario El objeto Horario que se desea guardar.
     * @return El horario guardado en la base de datos.
     */
    public Horario guardarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    /**
     * Elimina un horario de la base de datos.
     *
     * @param id El ID del horario a eliminar.
     * @return true si se eliminó exitosamente, false si no se encontró.
     */
    public boolean eliminarHorario(Long id) {
        if (horarioRepository.existsById(id)) {
            horarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
