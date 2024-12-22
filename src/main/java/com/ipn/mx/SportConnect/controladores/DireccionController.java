package com.ipn.mx.SportConnect.controladores;
import com.ipn.mx.SportConnect.entidades.Direccion;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?>  crearDireccion(@RequestBody Direccion direccion){
        try{
            direccionService.crearDireccion(direccion);
            return new ResponseEntity<>("Dirección creada con éxito.", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Error al crear la dirección: " + e.getMessage(), HttpStatus.BAD_REQUEST);        }
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
    public ResponseEntity<String> updateDireccion(@RequestBody Direccion direccion) {
        try {
            // Buscar la dirección existente por ID
            Direccion direccionExistente = direccionService.obtenerDireccion(direccion.getIdDireccion());
            if (direccionExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La dirección no existe.");
            }

            // Actualizar los campos de la dirección existente con los nuevos valores
            direccionExistente.setCalle(direccion.getCalle());
            direccionExistente.setAlcaldia(direccion.getAlcaldia());
            direccionExistente.setCodigoPostal(direccion.getCodigoPostal());
            direccionExistente.setCoords(direccion.getCoords());
            direccionExistente.setReferencias(direccion.getReferencias());
            direccionExistente.setEntre_calle1(direccion.getEntre_calle1());
            direccionExistente.setEntre_calle2(direccion.getEntre_calle2());

            // Guardar la dirección actualizada
            direccionService.updateDireccion(direccionExistente);

            return ResponseEntity.ok("La dirección fue actualizada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al actualizar la dirección: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al actualizar la dirección.");
        }
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
