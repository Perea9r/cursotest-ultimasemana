package semana.dos.cursorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semana.dos.cursorest.models.Curso;
import semana.dos.cursorest.services.CursoService;

@RestController
public class CursoController {
    @Autowired
    CursoService service;

    @GetMapping(value = "/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursos() {
        return service.cursos();
    }

    @GetMapping(value = "/curso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso buscarCurso(@PathVariable("id") int id) {
        return service.buscarCurso(id);
    }

    @PostMapping(value = "/curso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void altaCurso(@RequestBody Curso curso) {
        service.altaCurso(curso);
    }

    @PutMapping(value = "/curso/{id}/{duracion}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarCurso(@RequestBody Curso curso) {
        service.actualizarCurso(curso);
    }

    @DeleteMapping(value = "/curso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> eliminaCursos(@PathVariable("id") int id) {
        return service.eliminaCurso(id);
    }

    @GetMapping(value = "/curso/{minPrecio}/{maxPrecio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursosPorPrecio(@PathVariable int minPrecio, @PathVariable int maxPrecio) {
        return service.cursosPorPrecio(minPrecio, maxPrecio);
    }
}
