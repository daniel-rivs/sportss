package com.ipn.mx.SportConnect.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private int idEncargado; // Cambié el nombre a camelCase

    @OneToOne
    @JsonBackReference // Evita serializar al padre en el JSON
    @JoinColumn(name = "deportivo_id", referencedColumnName = "id_Deportivo") //en la tabla encargado, se tiene la fk deportivo_id
    private Deportivo deportivo;                                               //sin embargo, el id al que se hace referencia es id_deportivo

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
    @NotNull(message = "El RFC es obligatorio")
    @Size(min = 10, max = 13, message = "El RFC debe tener entre 10 y 13 caracteres")
    private String rfcCurp;

    @Column(name = "password")
    @NotNull(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contrasena; // Cambié el nombre a "contrasena" por convención

    @Override
    public String toString() {
        return "Encargado{" +
                "id_encargado: " + idEncargado +
                ", deportivo_id: " + deportivo.getIdDeportivo() +
                ", nombre_encargado: '" + nombre + '\'' +
                ", primer_apellido: '" + primerApellido + '\'' +
                ", segundo_apellido: '" + segundoApellido + '\'' +
                ", telefono_fijo: '" + telefonoFijo + '\'' +
                ", telefono_movil: '" + telefonoMovil + '\'' +
                ", cargo: '" + cargo + '\'' +
                ", rfc: '" + rfcCurp + '\'' +
                ", contrasena: '" + contrasena + '\'' +
                '}';
    }

}
