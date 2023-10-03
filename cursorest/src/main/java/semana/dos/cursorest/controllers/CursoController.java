package semana.dos.cursorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import semana.dos.cursorest.models.Curso;
import semana.dos.cursorest.services.CursoService;

@RestController
public class CursoController {
    @Autowired
    CursoService service;

    @GetMapping(value = "/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Curso>> cursos() {
        List<Curso> cursos = service.cursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable int id) {
        Curso curso = service.buscarCurso(id);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/curso")
    public ResponseEntity<Void> altaCurso(@RequestBody Curso curso) {
        service.altaCurso(curso);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/curso/{id}/{duracion}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarCurso(@RequestBody Curso curso) {
        service.actualizarCurso(curso);
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<List<Curso>> eliminaCursos(@PathVariable int id) {
        List<Curso> cursos = service.eliminaCurso(id);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/curso/{min}/{max}")
    public ResponseEntity<List<Curso>> cursosPorPrecio(@RequestParam int minPrecio, @RequestParam int maxPrecio) {
        List<Curso> cursos = service.cursosPorPrecio(minPrecio, maxPrecio);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}
