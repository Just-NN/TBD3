package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository{

    public List<Voluntario> getVoluntarios();
    public Voluntario createVoluntario(Voluntario voluntario);

    public boolean deleteVoluntario(int id);

    public Voluntario updateVoluntario(Voluntario voluntario, int id);

    public Voluntario getVoluntario(int id);
}
