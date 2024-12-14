package com.ipn.mx.SportConnect.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor //se usa un no args para poder deserializar los JSON
@AllArgsConstructor
@Builder
@Entity
@Table (name = "Deportivo", schema = "public") //Se pone el esquema público en donde se ubican las bases de datos en postgreSQL
public class Deportivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deportivo")
    private int idDeportivo; //en vez de usar id_deportivo se usa idDeportivo para poder generar el método de busqueda por rfc en EncargadoRespository

    @Column(name = "numero_registro", length = 100, nullable = false)
    private int numero_registro;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "acepta_mascotas", nullable = false)
    private boolean acepta_mascotas;

    @Column(name = "tiene_tienda", nullable = false)
    private boolean  tiene_tienda;

    @Column(name = "tiene_vestidores", nullable = false)
    private boolean tiene_vestidores;

    @Column(name = "tiene_regaderas", nullable = false)
    private boolean tiene_regaderas;

    @Column(name = "tiene_medico", nullable = false)
    private boolean tiene_medico;

    @OneToMany(mappedBy = "deportivo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) //Un deportivo tiene muchas canchas
    @JsonManagedReference
    private List<Cancha> canchas;

    @OneToMany(mappedBy = "deportivo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Encargado> encargados;

    @OneToMany(mappedBy = "deportivo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Horario> horarios;


    @Override
    public String toString(){
        return "Deportivo{" +
                "id_deportivo:" + idDeportivo +
                "numero_registro: " + numero_registro +
                "nombre: " + nombre +
                "acepta_mascotas: " + acepta_mascotas +
                "tiene_tienda: " + tiene_tienda +
                "tiene_vestidores: " + tiene_vestidores +
                "tiene_regaderas: " + tiene_regaderas +
                "tiene_medico: " + tiene_medico +
                '}';
    }
}
