package com.ipn.mx.SportConnect.servicios.impl;

import com.ipn.mx.SportConnect.entidades.Deportivo;
import com.ipn.mx.SportConnect.repositorios.DeportivoRepository;
import com.ipn.mx.SportConnect.servicios.DeportivoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//La implementación es la que lleva la anotación @Service y @Autowired, la interfaz no los lleva
@Service
public class DeportivoServiceImpl implements DeportivoService {

    /*@Autowired
    private CanchaRepository canchaRepository;

    @Autowired
    private EncargadoRepository encargadoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private DireccionRepository direccionRepository;*/

    @Autowired
    private DeportivoRepository deportivoRepository;

    @Override
    @Transactional
    public void crearDeportivo(Deportivo deportivo) {
        deportivoRepository.save(deportivo);
    }

    @Override
    public Deportivo obtenerDeportivo(int idDeportivo) {
        return deportivoRepository.findById(idDeportivo).orElse(null);
    }

    @Override
    public List<Deportivo> obtenerDeportivos() {
        return deportivoRepository.findAll();
    }

    @Override
    public void updateDeportivo(Deportivo deportivo) {
        deportivoRepository.save(deportivo);
    }

    @Override
    public void eliminarDeportivo(int idDeportivo) {
        deportivoRepository.deleteById(idDeportivo);
    }

    /*@Override
    @Transactional
    public String deleteDeportivoInfo(int ID_Deportivo) {
        try {
            // Elimina todos los registros asociados al ID_Deportivo
            canchaRepository.deleteByDeportivoId(ID_Deportivo);
            encargadoRepository.deleteByDeportivoId(ID_Deportivo);
            horarioRepository.deleteByDeportivoId(ID_Deportivo);

            // Encuentra el deportivo para obtener la dirección asociada
            Optional<Deportivo> deportivoOptional = deportivoRepository.findById(ID_Deportivo);

            if (deportivoOptional.isPresent()) {
                Deportivo deportivo = deportivoOptional.get();
                Long direccionId = deportivo.getDireccion().getId();

                // Elimina el registro de Deportivo
                deportivoRepository.delete(deportivo);

                // Si la dirección existe, la elimina
                if (direccionId != null) {
                    direccionRepository.deleteById(direccionId);
                }
            }

            return "Registros eliminados correctamente";
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar registros del deportivo", e);
        }
    }*/
}
