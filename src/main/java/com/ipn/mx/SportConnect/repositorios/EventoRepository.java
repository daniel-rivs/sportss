//Ahora el DAO se convierte en una interfaz, con nombre repository
//EN LA VIDA REAL, NO SE ELIMINA NADA, SE HACE SOFT DELETE.
package com.ipn.mx.SportConnect.repositorios;


import com.ipn.mx.SportConnect.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Una interfaz te dice que hacer, pero no te dice como. La implementación se realiza en otra parte,
//Una interfaz es como un catálogo de como se hacen las cosas
//Esta interfaz va a heredar de otra, que es JpaRepository
//Evento: se refiere a la entidad que se está manejando
//Integer: se refiere al tipo de dato que identifica a su llave primaria
//JpaRepository (mejor): Paginación y busquedas avanzadas
//CrudRepository: tiene menos métodos, pero tiene el crud base
//También esta PostgreRepository, pero está hecho más que nada para PostgreSQL
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    // Al extender JpaRepository, se heredan los métodos CRUD
}