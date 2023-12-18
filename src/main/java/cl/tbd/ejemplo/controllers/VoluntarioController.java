package cl.tbd.ejemplo.controllers;

import cl.tbd.ejemplo.models.Voluntario;
import cl.tbd.ejemplo.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    // Obtener todos los voluntarios
    @GetMapping
    public List<Voluntario> getTodosLosVoluntarios() {
        return voluntarioRepository.getVoluntarios();
    }

    // Obtener un voluntario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> getVoluntarioPorId(@PathVariable int id) {
        Voluntario voluntario = voluntarioRepository.getVoluntario(id);
        if (voluntario != null) {
            return new ResponseEntity<>(voluntario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo voluntario
    @PostMapping("/crear")
    public ResponseEntity<Voluntario> crearVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario nuevoVoluntario = voluntarioRepository.createVoluntario(voluntario);
        return new ResponseEntity<>(nuevoVoluntario, HttpStatus.CREATED);
    }

    // Actualizar un voluntario existente
    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> actualizarVoluntario(@RequestBody Voluntario voluntario, @PathVariable int id) {
        Voluntario voluntarioActualizado = voluntarioRepository.updateVoluntario(voluntario, id);
        if (voluntarioActualizado != null) {
            return new ResponseEntity<>(voluntarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un voluntario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVoluntario(@PathVariable int id) {
        boolean eliminado = voluntarioRepository.deleteVoluntario(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
