package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Tarea;
import cl.tbd.ejemplo.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    // Obtener todas las tareas
    @GetMapping
    public List<Tarea> getTodasLasTareas() {
        return tareaRepository.getTareas();
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaPorId(@PathVariable int id) {
        Tarea tarea = tareaRepository.getTarea(id);
        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva tarea
    @PostMapping("/crear")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaRepository.createTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    // Actualizar una tarea existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea, @PathVariable int id) {
        Tarea tareaActualizada = tareaRepository.updateTarea(tarea, id);
        if (tareaActualizada != null) {
            return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una tarea por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable int id) {
        boolean eliminada = tareaRepository.deleteTarea(id);
        if (eliminada) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}