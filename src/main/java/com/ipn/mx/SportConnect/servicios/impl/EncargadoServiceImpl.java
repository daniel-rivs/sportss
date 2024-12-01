package com.ipn.mx.SportConnect.servicios.impl;


import com.ipn.mx.SportConnect.entidades.Encargado;
import com.ipn.mx.SportConnect.repositorios.EncargadoRepository;
import com.ipn.mx.SportConnect.servicios.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncargadoServiceImpl implements EncargadoService {

    @Autowired
    private EncargadoRepository encargadoRepository;

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
