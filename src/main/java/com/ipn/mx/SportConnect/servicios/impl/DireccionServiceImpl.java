package com.ipn.mx.SportConnect.servicios.impl;
import com.ipn.mx.SportConnect.entidades.Direccion;
import com.ipn.mx.SportConnect.repositorios.DireccionRepository;
import com.ipn.mx.SportConnect.servicios.DireccionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//La implementación es la que lleva la anotación @Service y @Autowired, la interfaz no los lleva
@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional
    public void crearDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
    }

    @Override
    public Direccion obtenerDireccion(int idDireccion) {
        return direccionRepository.findById(idDireccion).orElse(null);
    }

    @Override
    public List<Direccion> obtenerDireccion() {
        return direccionRepository.findAll();
    }
    public boolean checkDireccionExistente(String calle, String alcaldia, String codigoPostal) {
        return direccionRepository.existsByCalleAndAlcaldiaAndCodigoPostal(calle, alcaldia, codigoPostal);
    }

    @Override
    public void updateDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
    }

    @Override
    public void eliminarDireccion(int idDireccion) {
        direccionRepository.deleteById(idDireccion);
    }


}
