package cl.tbd.ejemplo.services;

import cl.tbd.ejemplo.models.Voluntario;
import cl.tbd.ejemplo.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository= voluntarioRepository;
    }


    @GetMapping("/voluntario")
    public List<Voluntario> getTareas(){
        return voluntarioRepository.getVoluntarios();
    }

    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.createVoluntario(voluntario);
        return result;
    }

    @DeleteMapping("/voluntario/{id}")
    public boolean deleteVoluntario(@PathVariable int id){
        return voluntarioRepository.deleteVoluntario(id);
    }

    @PutMapping("/voluntario/{id}")
    @ResponseBody
    public Voluntario updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable int id){
        Voluntario result = voluntarioRepository.updateVoluntario(voluntario, id);
        return result;
    }

    @GetMapping("/voluntario/{id}")
    @ResponseBody
    public Voluntario getVoluntario(@PathVariable int id){
        Voluntario result = voluntarioRepository.getVoluntario(id);
        return result;
    }
}
