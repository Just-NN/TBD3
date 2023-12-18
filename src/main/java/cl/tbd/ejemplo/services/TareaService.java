package cl.tbd.ejemplo.services;


import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TareaService {

    private final TareaRepository tareaRepository;
    TareaService(TareaRepository tareaRepository){
        this.tareaRepository= tareaRepository;
    }


    @GetMapping("/tarea")
    public List<Tarea> getTareas(){
        return tareaRepository.getTareas();
    }

    @PostMapping("/tarea")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea result = tareaRepository.createTarea(tarea);
        return result;
    }

    @DeleteMapping("/tarea/{id}")
    public boolean deleteTarea(@PathVariable int id){
        return tareaRepository.deleteTarea(id);
    }

    @PutMapping("/tarea/{id}")
    @ResponseBody
    public Tarea updateTarea(@RequestBody Tarea tarea, @PathVariable int id){
        Tarea result = tareaRepository.updateTarea(tarea, id);
        return result;
    }

    @GetMapping("/tarea/{id}")
    @ResponseBody
    public Tarea getTarea(@PathVariable int id){
        Tarea result = tareaRepository.getTarea(id);
        return result;
    }

}