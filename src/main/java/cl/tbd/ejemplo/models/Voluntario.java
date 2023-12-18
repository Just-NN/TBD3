package cl.tbd.ejemplo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voluntario")
public class Voluntario {
    @BsonId
    ObjectId id_voluntario;

    private Integer id_voluntario2;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public ObjectId getId_voluntario() {
        return id_voluntario;
    }

    public Integer getId_voluntario2() {
        return id_voluntario2;
    }

    public void setId_voluntario(ObjectId id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setId_voluntario2(Integer id_voluntario2) {
        this.id_voluntario2 = id_voluntario2;
    }

    private String id_usuario;


    // Getters


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getId_usuario() {
        return id_usuario;
    }


    // Setters



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }



}
