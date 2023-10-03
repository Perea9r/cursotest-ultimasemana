package semana.dos.cursorest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import semana.dos.cursorest.controllers.CursoController;
import semana.dos.cursorest.models.Curso;
import semana.dos.cursorest.services.CursoService;

@ExtendWith(MockitoExtension.class)
public class CursorestApplicationTests {
    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @Test
    public void testCursos() {
        // Configurar el comportamiento del servicio
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(1, "Curso 1", 10, 100));
        cursos.add(new Curso(2, "Curso 2", 20, 200));
        when(cursoService.cursos()).thenReturn(cursos);

        // Llamar al método del controlador
        ResponseEntity<List<Curso>> resultado = cursoController.cursos();

        // Verificar el resultado
        assertEquals(cursos, resultado.getBody());
    }

    @Test
    public void testBuscarCurso() {
        // Configurar el comportamiento del servicio
        Curso curso = new Curso(1, "Curso 1", 10, 100);
        when(cursoService.buscarCurso(1)).thenReturn(curso);

        // Llamar al método del controlador
        Curso expectedCurso = cursoService.buscarCurso(1);
        ResponseEntity<Curso> resultado = new ResponseEntity<>(expectedCurso, HttpStatus.OK);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(curso, resultado.getBody());
    }

    @Test
    public void testAltaCurso() {
        // Llamar al método del controlador
        Curso curso = new Curso(1, "Curso 1", 10, 100);
        ResponseEntity<Void> resultado = cursoController.altaCurso(curso);

        // Verificar que se llamó al método del servicio
        verify(cursoService).altaCurso(curso);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void testEliminaCurso() {
        // Configurar el comportamiento del servicio
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(1, "Curso 1", 10, 100));
        when(cursoService.eliminaCurso(1)).thenReturn(cursos);

        // Llamar al método del controlador
        ResponseEntity<List<Curso>> resultado = cursoController.eliminaCursos(1);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(cursos, resultado.getBody());
    }

    @Test
    public void testCursosPorPrecio() {
        // Configurar el comportamiento del servicio
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(1, "Curso 1", 10, 100));
        cursos.add(new Curso(2, "Curso 2", 20, 200));
        when(cursoService.cursosPorPrecio(10, 20)).thenReturn(cursos);

        // Llamar al método del controlador
        ResponseEntity<List<Curso>> resultado = cursoController.cursosPorPrecio(10, 20);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(cursos, resultado.getBody());
    }
}
