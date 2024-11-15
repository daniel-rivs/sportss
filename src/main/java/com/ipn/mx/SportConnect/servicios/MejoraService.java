package com.ipn.mx.SportConnect.servicios;

import com.ipn.mx.SportConnect.entidades.Mejora;
import java.util.List;

public interface MejoraService {
    void crearMejora(Mejora mejora);
    Mejora obtenerMejora(int idMejora);
    List<Mejora> obtenerMejoras();
    void updateMejora(Mejora mejora);
    void eliminarMejora(int idMejora);
}
