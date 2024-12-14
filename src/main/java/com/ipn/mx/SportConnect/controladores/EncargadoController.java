package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Encargado;
import com.ipn.mx.SportConnect.servicios.impl.EncargadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/encargados")
@Tag(name = "Encargados", description = "API para la gestión de encargados")
public class EncargadoController {

    @Autowired
    private EncargadoServiceImpl encargadoServiceImpl;

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
    public Encargado guardarEncargado(@RequestBody Encargado encargado) {
        return encargadoServiceImpl.guardarEncargado(encargado);
    }
}
