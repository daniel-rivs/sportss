package com.ipn.mx.SportConnect.servicios.impl;

import com.ipn.mx.SportConnect.entidades.Mejora;
import com.ipn.mx.SportConnect.repositorios.MejoraRepository;
import com.ipn.mx.SportConnect.servicios.MejoraService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MejoraServiceImpl implements MejoraService {

    @Autowired
    MejoraRepository mejoraRepository;

    @Override
    @Transactional
    public void crearMejora(Mejora mejora) {
        mejoraRepository.save(mejora);
    }

    @Override
    @Transactional
    public Mejora obtenerMejora(int idMejora) {
        return mejoraRepository.findById(idMejora).orElse(null);
    }

    @Override
    @Transactional
    public List<Mejora> obtenerMejoras() {
        return mejoraRepository.findAll();
    }

    @Override
    @Transactional
    public void updateMejora(Mejora mejora) {
        mejoraRepository.save(mejora);
    }

    @Override
    @Transactional
    //Si quiero eliminar usando tódo el objeto, uso delete(mejora) en lugar de deleteById
    public void eliminarMejora(int idMejora) {
        mejoraRepository.deleteById(idMejora);
    }
}
