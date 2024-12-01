package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Deportivo;
import com.ipn.mx.SportConnect.servicios.DeportivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deportivos")
public class DeportivoController {

    @Autowired
    private DeportivoService deportivoService;

    @PostMapping("/createDeportivo")
    public String crearDeportivo(@RequestBody Deportivo deportivo){
        try{
            deportivoService.crearDeportivo(deportivo);
            return "Deportivo creado con éxito!";
        }catch(Exception e){
            return "Error al crear evento: " + e.getMessage();
        }
    }

    @GetMapping("/obtenerDeportivos")
    public List<Deportivo> obtenerDeportivos(){
        try{
            return deportivoService.obtenerDeportivos();
        } catch (Exception e) {
            System.out.println("Error al obtener todos los deportivos: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/obtenerDeportivo")
    //http://localhost:8080/api/deportivos/obtenerDeportivo?idDeportivo=11
    //Se hace el requestparam con el nombre de la variable que está en el parámetro, mas no con la que está definida en la BD
    public Deportivo obtenerDeportivo(@RequestParam int idDeportivo){
        try{
            return deportivoService.obtenerDeportivo(idDeportivo);
        } catch (Exception e) {
            System.out.println("Error al obtener un deportivo: " + e.getMessage());
        }
        return null;
    }

    @PutMapping("/updateDeportivo")
    public String updateDeportivo(@RequestBody Deportivo deportivo){
        try{
            deportivoService.updateDeportivo(deportivo);
            return "Deportivo actualizado con éxito!";
        } catch(Exception e){
            return("Error al actualizar un deportivo: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteDeportivo")
    public String deleteDeportivo(@RequestParam int idDeportivo){
        try{
            deportivoService.eliminarDeportivo(idDeportivo);
            return "Deportivo eliminado con éxito!";
        } catch(Exception e){
            return "Error al eliminar un deportivo: " + e.getMessage();
        }
    }
}
