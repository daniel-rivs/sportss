package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Deportivo;
import java.util.List;

public interface DeportivoService {
    Deportivo crearDeportivo(Deportivo deportivo);
    Deportivo obtenerDeportivo(int idDeportivo);
    List<Deportivo> obtenerDeportivos();
    void updateDeportivo(Deportivo deportivo);
    void eliminarDeportivo(int idDeportivo);
    List<Deportivo> getDeportivosByEncargado(String rfcCurp);
    //String deleteDeportivoInfo(int idDeportivo);
}
