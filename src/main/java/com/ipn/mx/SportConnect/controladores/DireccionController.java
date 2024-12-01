package com.ipn.mx.SportConnect.controladores;
import com.ipn.mx.SportConnect.entidades.Direccion;
import org.springframework.http.ResponseEntity;
import com.ipn.mx.SportConnect.servicios.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @PostMapping("/createDireccion")
    public String crearDireccion(@RequestBody Direccion direccion){
        try{
            direccionService.crearDireccion(direccion);
            return "Direccion añadida con éxito!";
        }catch(Exception e){
            return "Error al añadir direccion: " + e.getMessage();
        }
    }
    //todas las direcciones
    @GetMapping("/obtenerDirecciones")
    public List<Direccion> obtenerDireccion(){
        try{
            return direccionService.obtenerDireccion();
        } catch (Exception e) {
            System.out.println("Error al obtener todas las direcciones: " + e.getMessage());
        }
        return null;
    }
    //Obtener una direccion por id
    @GetMapping("/obtenerDireccion")
    public Direccion obtenerDireccion(@RequestParam int idDireccion){
        try{
            return direccionService.obtenerDireccion(idDireccion);
        } catch (Exception e) {
            System.out.println("Error al obtener una dirección: " + e.getMessage());
        }
        return null;
    }
    //Obtener una direccion por los datos dados
    @GetMapping("/checkDireccion")
    public ResponseEntity<Boolean> checkDireccionExistente(@RequestParam String calle,
                                                           @RequestParam String alcaldia,
                                                           @RequestParam String codigo_postal) {
        boolean exists = direccionService.checkDireccionExistente(calle, alcaldia, codigo_postal);
        return ResponseEntity.ok(exists);
    }

    @PutMapping("/updateDireccion")
    public String updateDireccion(@RequestBody Direccion direccion){
        try{
            direccionService.updateDireccion(direccion);
        } catch(Exception e){
            System.out.println("Error al actualizar la dirección: " + e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/deleteDireccion")
    public String deleteDireccion(@RequestParam int idDireccion){
        try{
            direccionService.eliminarDireccion(idDireccion);
        } catch(Exception e){
            return "Error al eliminar la dirección: " + e.getMessage();
        }
        return null;
    }
}
