package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Tarea;

import java.util.List;

public interface TareaRepository {

    public List<Tarea> getTareas();
    public Tarea createTarea(Tarea tarea);

    public boolean deleteTarea(int id);

    public Tarea updateTarea(Tarea tarea, int id);

    public Tarea getTarea(int id);
}