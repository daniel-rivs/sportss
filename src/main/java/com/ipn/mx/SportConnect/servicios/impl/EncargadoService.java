package com.miempresa.proyectospring.service;


import com.miempresa.proyectospring.model.Encargado;
import com.miempresa.proyectospring.repository.EncargadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncargadoService {

    @Autowired
    private EncargadoRepo encargadoRepository;

    public Encargado guardarEncargado(Encargado encargado) {
        return encargadoRepository.save(encargado);
    }

    public Optional<Encargado> obtenerEncargadoPorId(Long id) {
        return encargadoRepository.findById(id);
    }

    public Optional<Encargado> buscarPorRFC(String RFC_CURP) {
        return encargadoRepository.findByRfcCurp(RFC_CURP);
    }

    public void eliminarEncargado(Long id) {
        encargadoRepository.deleteById(id);
    }
}
