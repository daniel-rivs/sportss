package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Deportivo;
import java.util.List;

public interface DeportivoService {
    void crearDeportivo(Deportivo deportivo);
    Deportivo obtenerDeportivo(int idDeportivo);
    List<Deportivo> obtenerDeportivos();
    void updateDeportivo(Deportivo deportivo);
    void eliminarDeportivo(int idDeportivo);
    //String deleteDeportivoInfo(int idDeportivo);
}
