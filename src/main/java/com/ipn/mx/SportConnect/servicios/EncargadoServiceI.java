package com.miempresa.proyectospring.service;

import com.miempresa.proyectospring.model.Encargado;

import java.util.List;

public interface EncargadoServiceI {

    // Método para crear un nuevo encargado
    void crearEncargado(Encargado encargado);

    // Método para obtener un encargado por su ID
    Encargado obtenerEncargado(Long idEncargado);

    // Método para obtener todos los encargados
    List<Encargado> obtenerEncargados();

    // Método para actualizar un encargado
    void updateEncargado(Encargado encargado);

    // Método para eliminar un encargado
    void eliminarEncargado(Long idEncargado);

    // Método para verificar si un encargado con el mismo nombre ya existe
    boolean checkEncargadoExistente(String nombre, String correo);
}
