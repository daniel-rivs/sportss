package com.miempresa.proyectospring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "encargados") // Mapea esta clase a la tabla "encargados"
public class Encargado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    @Column(name = "ID_Encargado") // Asegúrate de que la columna en la base de datos sea la correcta
    private Long idEncargado; // Cambié el nombre a camelCase

    @Column(name = "ID_Deportivo") // Especificamos explícitamente el nombre de la columna
    private String idDeportivo;

    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    @Column(name = "Telefono_Fijo") // Especificamos explícitamente el nombre de la columna
    private String telefonoFijo;

    @Column(name = "Telefono_Movil") // Especificamos explícitamente el nombre de la columna
    private String telefonoMovil;

    private String cargo;

    @Column(name = "RFC_CURP") // Especificamos explícitamente el nombre de la columna
    private String rfcCurp;

    private String contrasena; // Cambié el nombre a "contrasena" por convención
}
