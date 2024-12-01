package com.ipn.mx.SportConnect.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Encargado", schema = "public") // Mapea esta clase a la tabla "encargados"
public class Encargado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    @Column(name = "id_encargado") // Asegúrate de que la columna en la base de datos sea la correcta
    private Long idEncargado; // Cambié el nombre a camelCase

    @Column(name = "deportivo_id") // Especificamos explícitamente el nombre de la columna
    private int idDeportivo;

    @Column(name = "nombre_encargado")
    private String nombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "Telefono_Fijo") // Especificamos explícitamente el nombre de la columna
    private String telefonoFijo;

    @Column(name = "Telefono_Movil") // Especificamos explícitamente el nombre de la columna
    private String telefonoMovil;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "rfc") // Especificamos explícitamente el nombre de la columna
    private String rfcCurp;

    @Column(name = "password")
    private String contrasena; // Cambié el nombre a "contrasena" por convención
}
