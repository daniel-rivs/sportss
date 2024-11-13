//El controlador maneja los HTTPRequests, los return ya regresan todo en formato json
//Endpoints para que los clientes se conecten y obtengan información
package com.ipn.mx.SportConnect.controladores;

import com.ipn.mx.SportConnect.entidades.Evento;
import com.ipn.mx.SportConnect.servicios.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"*"}) para lo de CORS (si no se usa el contenido de WebConfig)
@RequestMapping("/api/eventos") //nombre base
public class EventoController {

    @Autowired
    private EventoService eventoService; // Usas el servicio, no el DAO directamente

    @PostMapping("/create")
    public String crearEvento(@RequestBody Evento evento) {
        try {
            eventoService.crearEvento(evento); // Llama al servicio para manejar la lógica de negocio
            return "Evento creado con éxito!";
        } catch (Exception e) {
            return "Error al crear el evento: " + e.getMessage();
        }
    }

    @GetMapping("/readAll")
    public List<Evento> readAllEventos(){
        try{
            return eventoService.readAll();
        }catch (Exception e){
            System.out.println("Error al obtener todos los eventos" + e.getMessage());
        }
            return null;
    }

    @GetMapping("/readOne")
    public Evento readOneEvento(@RequestParam int idEvento){
        try{
            return eventoService.readOne(idEvento);
        }catch (Exception e){
            System.out.println("Error al obtener evento" + e.getMessage());
        }
        return null;
    }

    @PutMapping("/update")
    public String updateEvento(@RequestBody Evento evento) {
        try {
            eventoService.updateEvento(evento); // Llama al servicio para manejar la lógica de negocio
            return "Evento actualizado con éxito!";
        } catch (Exception e) {
            return "Error al actualizar el evento: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete")
    public String deleteEvento(@RequestParam int idEvento){
        try{
            eventoService.deleteEvento(idEvento);
            return "Evento eliminado con éxito!";
        } catch (Exception e) {
            return "Error al eliminar evento: " + e.getMessage();
        }
    }
}
