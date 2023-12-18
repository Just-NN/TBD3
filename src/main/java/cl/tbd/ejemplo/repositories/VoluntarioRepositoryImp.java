package cl.tbd.ejemplo.repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cl.tbd.ejemplo.models.Voluntario;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {

    @Autowired
    MongoDatabase database;

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        collection.insertOne(voluntario);
        return voluntario;
    }

    @Override
    public List<Voluntario> getVoluntarios() {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        List <Voluntario> voluntario = collection.find().into(new ArrayList<>());
        return voluntario;
    }

    @Override
    public boolean deleteVoluntario(int id) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        collection.deleteOne(new Document("id_voluntario2", id));
        return true;
    }

    @Override
    public Voluntario updateVoluntario(Voluntario voluntario, int id) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        collection.updateOne(eq("id_voluntario2", id), new Document("$set", new Document("nombre", voluntario.getNombre())));
        collection.updateOne(eq("id_voluntario2", id), new Document("$set", new Document("apellido", voluntario.getApellido())));
        collection.updateOne(eq("id_voluntario2", id), new Document("$set", new Document("telefono", voluntario.getTelefono())));
        collection.updateOne(eq("id_voluntario2", id), new Document("$set", new Document("direccion", voluntario.getDireccion())));
        collection.updateOne(eq("id_voluntario2", id), new Document("$set", new Document("id_usuario", voluntario.getId_usuario())));
        return voluntario;
    }

    @Override
    public Voluntario getVoluntario(int id) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        Voluntario voluntario = collection.find(eq("id_voluntario2", id)).first();
        return voluntario;
    }
}
