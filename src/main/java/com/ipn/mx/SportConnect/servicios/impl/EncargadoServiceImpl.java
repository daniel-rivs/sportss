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

    @Override
    public Encargado guardarEncargado(Encargado encargado) {
        return encargadoRepository.save(encargado);
    }

    @Override
    public Encargado obtenerEncargadoPorId(int id) {
        System.out.println("Obteniendo encargado con ID: " + id);

        return encargadoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Encargado> buscarPorRFC(String RFC_CURP) {
        return encargadoRepository.findByRfcCurp(RFC_CURP);
    }

    @Override
    public void updateEncargado(Encargado encargado) {
        encargadoRepository.save(encargado);
    }
}