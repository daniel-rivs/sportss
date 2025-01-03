package com.ipn.mx.SportConnect.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mejoras", schema = "public")
public class Mejora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mejora;

    @ManyToOne
    @JoinColumn(name = "cancha_id", referencedColumnName = "id_cancha")
    @JsonBackReference // Evita serializar al padre en el JSON
    private Cancha cancha;

    @Column(name = "nombre_mejora", length = 100, nullable = false)
    private String nombre_mejora;

    @Column(name = "descripcion_mejora", length = 100, nullable = false)
    private String descripcion_mejora;

    @Column(name = "justificacion_mejora", length = 100, nullable = false)
    private String justificacion_mejora;

    @Column(name = "fecha_implementación", length = 100, nullable = false)
    private Date fecha_implementacion;

    /*@OneToOne
    @JoinColumn(name = "cancha_id", referencedColumnName = "id_cancha")
    private Cancha cancha;*/

    @Override
    public String toString(){
        return "Deportivo{" +
                "id_mejora:" + id_mejora +
                "cancha_id: " + cancha.getId_cancha() +
                "nombre_mejora: " + nombre_mejora +
                "descripcion_mejora: " + descripcion_mejora +
                "justificacion_mejora: " + justificacion_mejora +
                "fecha_implementacion: " + fecha_implementacion +
                '}';
    }
}
