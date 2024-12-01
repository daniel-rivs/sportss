package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Encargado;
import com.ipn.mx.SportConnect.servicios.impl.EncargadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/encargados")
@Tag(name = "Encargados", description = "API para la gestión de encargados")
public class EncargadoController {

    @Autowired
    private EncargadoServiceImpl encargadoServiceImpl;

    @Operation(summary = "Obtener un encargado por ID",
            description = "Devuelve los detalles de un encargado según su ID")
    @GetMapping("/obtenerEncargado/{id}")
    public Optional<Encargado> obtenerEncargado(@PathVariable Long id) {
        return encargadoServiceImpl.obtenerEncargadoPorId(id);
    }

    @Operation(summary = "Crear o actualizar un encargado",
            description = "Guarda un nuevo encargado o actualiza uno existente")
    @PostMapping("/guardarEncargado")
    public Encargado guardarEncargado(@RequestBody Encargado encargado) {
        return encargadoServiceImpl.guardarEncargado(encargado);
    }

    @Operation(summary = "Eliminar un encargado",
            description = "Elimina un encargado existente según su ID")
    @DeleteMapping("/eliminarEncargado/{id}")
    public void eliminarEncargado(@PathVariable Long id) {
        encargadoServiceImpl.eliminarEncargado(id);
    }
}
