package semana.dos.cursorest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semana.dos.cursorest.models.Curso;
import semana.dos.cursorest.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    CursoRepository repository;

    public List<Curso> cursos() {
        return repository.findAll();
    }

    @Override
    public void altaCurso(Curso curso) {
        repository.save(curso);
    }

    @Override
    public Curso buscarCurso(int id) {
        Optional<Curso> curso = repository.findById(id);
        return curso.isPresent() ? curso.get() : null;
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public List<Curso> eliminaCurso(int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @Override
    public List<Curso> cursosPorPrecio(int minPrecio, int maxPrecio) {
        return repository.findByPrecioBetween(minPrecio, maxPrecio);
    }
}
