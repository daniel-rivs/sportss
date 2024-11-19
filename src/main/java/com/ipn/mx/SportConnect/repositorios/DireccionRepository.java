package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    //Aquí va tódo el CRUD, intrínsicamente
    boolean existsByCalleAndAlcaldiaAndCodigoPostal(String calle, String alcaldia, String codigoPostal);
}
