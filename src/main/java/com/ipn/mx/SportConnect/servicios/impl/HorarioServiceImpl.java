package com.ipn.mx.SportConnect.servicios.impl;

import com.ipn.mx.SportConnect.entidades.Horario;
import com.ipn.mx.SportConnect.repositorios.HorarioRepository;
import com.ipn.mx.SportConnect.servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta clase como un componente de servicio en Spring.
public class HorarioServiceImpl implements HorarioService {

    @Autowired // Inyecta la dependencia del repositorio de Horarios.
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> obtenerHorarios() {
        return horarioRepository.findAll();
    }

    public List<Horario> obtenerHorariosPorDeportivo(int deportivoid) {
        return horarioRepository.findByIdDeportivo(deportivoid);
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
