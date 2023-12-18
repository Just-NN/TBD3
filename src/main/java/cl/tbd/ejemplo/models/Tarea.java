package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tarea")
public class Tarea {
    @BsonId
    ObjectId id_tarea;

    private Integer id_tarea2;

    private String asunto_tarea;

    private Boolean estado_tarea;

    private Integer id_emergencia;

    public ObjectId get_id() {
        return id_tarea;
    }

    public Integer getId_tarea2() {
        return id_tarea2;
    }

    public void set_id(ObjectId id_tarea) {
        this.id_tarea = id_tarea;
    }

    public void setId_tarea2(Integer id_tarea2) {
        this.id_tarea2 = id_tarea2;
    }

    public String getAsunto_tarea() {
        return asunto_tarea;
    }

    public void setAsunto_tarea(String asunto_tarea) {
        this.asunto_tarea = asunto_tarea;
    }

    public Boolean getEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(Boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

}