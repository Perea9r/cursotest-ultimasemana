package semana.dos.cursorest.services;

import java.util.List;

import semana.dos.cursorest.models.Curso;

public interface CursoService {
    List<Curso> cursos();
    void altaCurso(Curso curso);
    Curso buscarCurso(int id);
    Curso actualizarCurso(Curso curso);
    List<Curso> eliminaCurso(int id);
}
