package semanados.curso.cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semanados.curso.cliente.models.Formacion;
import semanados.curso.cliente.services.FormacionService;

@RestController
public class FormacionController {
    @Autowired
    private FormacionService formacionService;

    /**
     * Devuelve la lista de formaciones disponibles.
     *
     * @return la lista de formaciones disponibles.
     */
    @GetMapping(value = "/formaciones", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formacion> formaciones() {
        return formacionService.getCursos();
    }

    /**
     * Da de alta un nuevo curso a partir de los datos de formación recibidos en el
     * cuerpo.
     *
     * @param formacion los datos de formación del nuevo curso.
     */
    @PostMapping(value = "/formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void altaFormacion(@RequestBody Formacion formacion) {
        formacionService.altaCurso(formacion);
    }
}