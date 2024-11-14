package com.ipn.mx.SportConnect.repositorios;

import com.ipn.mx.SportConnect.entidades.Deportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportivoRepository extends JpaRepository<Deportivo, Integer> {
    //Todos los métodos CRUD
}
