package semanados.curso.cliente.services;

import java.util.List;
import semanados.curso.cliente.models.Formacion;

public interface FormacionService {
    List<Formacion> getCursos();
    void altaCurso(Formacion formacion);
}
