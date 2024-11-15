package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Mejora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MejoraRepository extends JpaRepository<Mejora, Integer> {
    //Aquí va tódo el CRUD, intrínsicamente
}
