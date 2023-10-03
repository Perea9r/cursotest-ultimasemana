package semanados.curso.cliente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    private int id;
    private String nombre;
    private int duracion;
    private int precio;

    public Curso() {

    }

    public Curso(int id, String nombre, int duracion, int precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
