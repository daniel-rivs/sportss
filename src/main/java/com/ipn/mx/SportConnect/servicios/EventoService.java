package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Evento;
import com.ipn.mx.SportConnect.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//También se debe crear una interfaz que contenga todos los métodos
//contenidos en la clase
@Service
public class EventoService{
//Se usa save tanto para crear como para actualizar.
    @Autowired
    private EventoRepository eventoRepository;

    //@Override
    //@Transactional se aplican cuando ya se tiene la interfaz del servicio, esto se implementa en EventoServiceImpl
    public void crearEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public Evento readOne(int idEvento) {
        return eventoRepository.findById(idEvento).orElse(null);
    }

    public List<Evento> readAll() {
        return eventoRepository.findAll();
    }

    public void updateEvento(Evento evento) {
        eventoRepository.save(evento); // `save()` se usa tanto para crear como para actualizar
    }

    public void deleteEvento(int idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    /*
    @Override
    @Transactional //Voy a hacer una modificación persistente en la base de datos.
    public Evento buscarporId(Long id){
        return eventoRepository.findById(id).orElse(null)
    }
    */
}
