package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Encargado;
import com.ipn.mx.SportConnect.entidades.Horario;
import com.ipn.mx.SportConnect.servicios.EncargadoService;
import com.ipn.mx.SportConnect.servicios.impl.EncargadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/encargados")
@Tag(name = "Encargados", description = "API para la gestión de encargados")
public class EncargadoController {

    @Autowired
    private EncargadoServiceImpl encargadoServiceImpl;
    @Autowired
    private EncargadoService encargadoService;

    @Operation(summary = "Iniciar sesión",
            description = "Verifica las credenciales del usuario y devuelve un estado correspondiente")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Encargado encargado) {
        try {
            System.out.println(encargado.getRfcCurp() + " " + encargado.getContrasena());
            // Verificar si es admin antes de consultar la base de datos
            if ("developer".equals(encargado.getRfcCurp()) && "Admin123".equals(encargado.getContrasena())) {
                System.out.println("Admin detectado.");
                return ResponseEntity.status(201).body("Admin detectado");
            }

            System.out.println("Intentando iniciar sesión con RFC: " + encargado.getRfcCurp());
            Optional<Encargado> encargadoOptional = encargadoServiceImpl.buscarPorRFC(encargado.getRfcCurp());

            if (encargadoOptional.isEmpty()) {
                System.out.println("Encargado no encontrado.");
                return ResponseEntity.status(401).body("Credenciales incorrectas");
            }

            Encargado encontrado = encargadoOptional.get();
            //System.out.println("Encargado encontrado: " + encontrado.getRfcCurp() + " " + encontrado.getContrasena() + encargado.getContrasena());

            if (!encontrado.getContrasena().equals(encargado.getContrasena())) {
                System.out.println("Contraseña incorrecta para RFC: " + encargado.getRfcCurp());
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }

            System.out.println("Inicio de sesión exitoso.");
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (Exception e) {
            System.out.println("Error interno del servidor: " + e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @Operation(summary = "Obtener un encargado por ID",
            description = "Devuelve los detalles de un encargado según su ID")
    @GetMapping("/obtenerEncargado/{id}")
    public Encargado obtenerEncargado(@PathVariable int id) {
        System.out.println("Obteniendo encargado con ID: " + id);
        return encargadoServiceImpl.obtenerEncargadoPorId(id);
    }

    @Operation(summary = "Crear o actualizar un encargado",
            description = "Guarda un nuevo encargado o actualiza uno existente")
    @PostMapping("/guardarEncargado")
    public ResponseEntity<?> guardarEncargado(@RequestBody Encargado encargado) {
        try {
                encargadoServiceImpl.guardarEncargado(encargado); // Guardar cada horario individualmente
            return ResponseEntity.status(HttpStatus.CREATED).body("Encargado guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al guardar encargado: " + e.getMessage());
        }
    }

    @PutMapping("/updateEncargado")
    public ResponseEntity<?> updateEncargado(@RequestBody Encargado encargado) {
        try {
            // Verificar si el encargado ya existe
            Encargado encargadoExistente = encargadoServiceImpl.obtenerEncargadoPorId(encargado.getIdEncargado());
            if (encargadoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encargado no encontrado");
            }

            // Actualizar solo los campos del encargado, sin modificar el deportivo
            encargadoExistente.setNombre(encargado.getNombre());
            encargadoExistente.setPrimerApellido(encargado.getPrimerApellido());
            encargadoExistente.setSegundoApellido(encargado.getSegundoApellido());
            encargadoExistente.setTelefonoFijo(encargado.getTelefonoFijo());
            encargadoExistente.setTelefonoMovil(encargado.getTelefonoMovil());
            encargadoExistente.setCargo(encargado.getCargo());
            encargadoExistente.setRfcCurp(encargado.getRfcCurp());
            encargadoExistente.setContrasena(encargado.getContrasena());

            // Guardar los cambios
            encargadoServiceImpl.guardarEncargado(encargadoExistente);

            return ResponseEntity.status(HttpStatus.OK).body("Encargado actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar encargado: " + e.getMessage());
        }
    }

}
