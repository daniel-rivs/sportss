package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Mejora;
import com.ipn.mx.SportConnect.servicios.MejoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mejoras")
public class MejoraController {

    @Autowired
    private MejoraService mejoraService;

    @PostMapping("/createMejora")
    public String crearMejora(@RequestBody Mejora mejora) {
        try{
            mejoraService.crearMejora(mejora);
            return "Mejora creada con éxito.";
        }catch(Exception e){
            System.out.println("Error al crear la mejora: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/obtenerMejoras")
    public List<Mejora> obtenerMejoras(){
        try{
            return mejoraService.obtenerMejoras();
        } catch (Exception e) {
            System.out.println("Error al obtener mejoras: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/obtenerMejora")
    public Mejora obtenerMejora(int idMejora){
        try{
            return mejoraService.obtenerMejora(idMejora);
        } catch(Exception e){
            System.out.println("Error al obtener mejora: " + e.getMessage());
        }
        return null;
    }

    @PutMapping("/updateMejora")
    public String updateMejora(@RequestBody Mejora mejora) {
        try{
            mejoraService.updateMejora(mejora);
            return "Mejora actualizada con éxito";
        } catch (Exception e) {
            return "Error al actualizar la mejora: " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteMejora")
    public String deleteMejora(int idMejora) {
        try{
            mejoraService.eliminarMejora(idMejora);
            return "Mejora eliminada con éxito.";
        } catch (Exception e){
            return "Error al eliminar la mejora: " + e.getMessage();
        }
    }
}
