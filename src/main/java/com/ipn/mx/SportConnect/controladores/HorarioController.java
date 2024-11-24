package com.miempresa.proyectospring.controller;

import com.miempresa.proyectospring.model.Horario;
import com.miempresa.proyectospring.service.HorarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Operation(
            summary = "Obtener horarios por ID de Deportivo",
            description = "Este endpoint devuelve una lista de horarios asociados a un ID de deportivo proporcionado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida exitosamente."),
            @ApiResponse(responseCode = "404", description = "No se encontraron horarios para el ID de deportivo proporcionado.")
    })
    @GetMapping("/deportivo/{idDeportivo}")
    public List<Horario> obtenerHorariosPorDeportivo(@PathVariable String idDeportivo) {
        List<Horario> horarios = horarioService.obtenerHorariosPorDeportivo(idDeportivo);
        if (horarios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron horarios para el deportivo con id: " + idDeportivo);
        }
        return horarios;
    }

    @Operation(
            summary = "Crear o actualizar un horario",
            description = "Este endpoint permite crear un nuevo horario o actualizar uno existente. Es necesario proporcionar los datos del horario en el cuerpo de la solicitud."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Horario creado o actualizado exitosamente.")
    })
    @PostMapping
    public Horario guardarHorario(@RequestBody Horario horario) {
        return horarioService.guardarHorario(horario);
    }

    @Operation(
            summary = "Eliminar un horario por ID",
            description = "Este endpoint elimina un horario específico basado en su ID único."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Horario eliminado exitosamente."),
            @ApiResponse(responseCode = "404", description = "No se encontró un horario con el ID proporcionado.")
    })
    @DeleteMapping("/{id}")
    public void eliminarHorario(@PathVariable Long id) {
        if (!horarioService.eliminarHorario(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario con id " + id + " no encontrado.");
        }
    }
}
