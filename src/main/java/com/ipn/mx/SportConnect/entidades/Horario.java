package com.miempresa.proyectospring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Genera automáticamente getters, setters y otros métodos comunes como toString().
@Entity // Indica que esta clase es una entidad JPA que mapea a una tabla de base de datos.
@Table(name = "horarios") // Especifica el nombre de la tabla correspondiente en la base de datos.
public class Horario {

    @Id // Define la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-incremental.
    @Column(name = "ID_Horario") // Especifica el nombre exacto de la columna en la base de datos.
    private Long idHorario;

    @Column(name = "ID_Deportivo") // Relaciona esta propiedad con la columna "ID_Deportivo".
    private String idDeportivo;

    @Column(name = "dia_semana") // Relaciona esta propiedad con la columna "dia_semana".
    private String diaSemana;

    @Column(name = "hora_apertura") // Relaciona esta propiedad con la columna "hora_apertura".
    private String horaApertura;

    @Column(name = "hora_cierre") // Relaciona esta propiedad con la columna "hora_cierre".
    private String horaCierre;

    private boolean inhabil; // Esta columna se genera automáticamente a partir del nombre del atributo.
}
