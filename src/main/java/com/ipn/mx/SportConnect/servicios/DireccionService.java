package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Direccion;
import java.util.List;

// Esta interfaz define los métodos que la clase DireccionServiceImpl debe implementar
public interface DireccionService {

    // Método para crear una nueva dirección
    void crearDireccion(Direccion direccion);

    // Método para obtener una dirección por su ID
    Direccion obtenerDireccion(int idDireccion);

    public boolean checkDireccionExistente(String calle, String alcaldia, String codigoPostal);

    // Método para obtener todas las direcciones
    List<Direccion> obtenerDireccion();

    // Método para actualizar una dirección
    void updateDireccion(Direccion direccion);

    // Método para eliminar una dirección
    void eliminarDireccion(int idDireccion);
}
