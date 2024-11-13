//Ya está lista para JPA
package com.ipn.mx.SportConnect.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//Si solo quiero @Setters o @Getters, solo se usan esas anotaciones.
@Table(name = "Eventos")
public class Evento implements Serializable {
//La anotación de columnas en ciertas variables se puede exceptuar en caso de que
//tengan el mismo nombre que en la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que se genera de forma autoincremental
    @Column(name = "idEvento")
    private int idEvento;

    @Column(name = "nombreEvento", nullable = false)
    private String nombreEvento;

    @Column(name = "fechaevento", nullable = false) // Asegúrate de que el nombre coincide con el de la base de datos
    private Date fechaEvento;
    //Si fuera una descripción, se puede usar @Column(name = "duracion", length = 100, nullable = false)
    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", fechaEvento=" + fechaEvento +
                ", duracion=" + duracion +
                '}';
    }
}
