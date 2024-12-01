package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Horario;
import com.ipn.mx.SportConnect.servicios.HorarioService;
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

    @GetMapping("/obtenerHorarios")
    public List<Horario> obtenerHorarios(){
        try{
            return horarioService.obtenerHorarios();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los deportivos: " + e.getMessage());
        }
        return null;
    }

    @Operation(
            summary = "Obtener horarios por ID de Deportivo",
            description = "Este endpoint devuelve una lista de horarios asociados a un ID de deportivo proporcionado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida exitosamente."),
            @ApiResponse(responseCode = "404", description = "No se encontraron horarios para el ID de deportivo proporcionado.")
    })
    @GetMapping("/deportivo/{idDeportivo}")
    public List<Horario> obtenerHorariosPorDeportivo(@PathVariable int idDeportivo) {
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
    @PostMapping("/guardarHorario")
    public String guardarHorario(@RequestBody Horario horario) {
        try {
            horarioService.guardarHorario(horario);
        } catch (Exception e) {
            return "Error al guardar horario: " + e.getMessage();
        }
        return "Horario guardado con éxito";
    }

    @Operation(
            summary = "Eliminar un horario por ID",
            description = "Este endpoint elimina un horario específico basado en su ID único."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Horario eliminado exitosamente."),
            @ApiResponse(responseCode = "404", description = "No se encontró un horario con el ID proporcionado.")
    })
    @DeleteMapping("/deleteHorario")
    public void eliminarHorario(@RequestParam Long id) {
        if (!horarioService.eliminarHorario(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario con id " + id + " no encontrado.");
        }
    }
}
