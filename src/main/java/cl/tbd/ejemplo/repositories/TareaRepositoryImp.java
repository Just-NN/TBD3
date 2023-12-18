package cl.tbd.ejemplo.repositories;

import cl.tbd.ejemplo.models.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class TareaRepositoryImp implements TareaRepository {

    @Autowired
    MongoDatabase database;

    @Override
    public Tarea createTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.insertOne(tarea);
        return tarea;
   }

    @Override
    public List<Tarea> getTareas() {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        List <Tarea> tareas = collection.find().into(new ArrayList<>());
        return tareas;
    }

    @Override
    public boolean deleteTarea(int id) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.deleteOne(new Document("id_tarea2", id));
        return true;
    }

    @Override
    public Tarea updateTarea(Tarea tarea, int id) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.updateOne(eq("id_tarea2", id), new Document("$set", new Document("id_emergencia", tarea.getId_emergencia())));
        collection.updateOne(eq("id_tarea2", id), new Document("$set", new Document("id_voluntario", tarea.getAsunto_tarea())));
        collection.updateOne(eq("id_tarea2", id), new Document("$set", new Document("id_estado", tarea.getEstado_tarea())));
        collection.updateOne(eq("id_tarea2", id), new Document("$set", new Document("descripcion", tarea.getId_emergencia())));
        return tarea;
    }

    @Override
    public Tarea getTarea(int id) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        Tarea tarea = collection.find(eq("id_tarea2", id)).first();
        return tarea;
    }



    
}