package semanados.curso.cliente.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import semanados.curso.cliente.models.Curso;
import semanados.curso.cliente.models.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
    @Autowired
    private RestTemplate restTemplate;
    private String cursosUrl = "http://localhost:8080/";

    @Override
    public List<Formacion> getCursos() {
        List<Curso> response = Arrays.asList(restTemplate.getForObject(cursosUrl + "cursos", Curso[].class));
        List<Formacion> formaciones = new ArrayList<>();

        for (Curso curso : response) {
            int asignaturas = curso.getDuracion() >= 50 ? 10 : 5;
            formaciones.add(new Formacion(curso.getNombre(), asignaturas, curso.getPrecio()));
        }

        return formaciones;
    }

    @Override
    public void altaCurso(Formacion formacion) {
        boolean existe = false;
        List<Curso> response = Arrays.asList(restTemplate.getForObject(cursosUrl + "cursos", Curso[].class));

        for (Curso curso : response) {
            if (curso.getNombre().equals(formacion.getCurso()))
                existe = true;
        }

        if (!existe) {
            Curso curso = new Curso(0, formacion.getCurso(), formacion.getAsignaturas() * 10, formacion.getPrecio());
            restTemplate.postForLocation(cursosUrl + "curso", curso);
        }
    }
}
