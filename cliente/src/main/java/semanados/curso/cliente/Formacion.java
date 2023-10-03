package semanados.curso.cliente;

public class Formacion {
    private String curso;
    private int asignaturas;
    private int precio;

    public Formacion() {

    }

    public Formacion(String curso, int asignaturas, int precio) {
        this.curso = curso;
        this.asignaturas = asignaturas;
        this.precio = precio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Formacion [curso=" + curso + ", asignaturas=" + asignaturas + ", precio=" + precio + "]";
    }

}
