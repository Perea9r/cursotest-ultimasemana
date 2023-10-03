package semana.dos.cursorest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import semana.dos.cursorest.models.Curso;

/**
 * Busca cursos que se encuentren dentro de un rango de precios.
 *
 * @param minPrecio el precio mínimo del rango.
 * @param maxPrecio el precio máximo del rango.
 * @return una lista de cursos que se encuentran dentro del rango de precios.
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
    List<Curso> findByPrecioBetween(int minPrecio, int maxPrecio);
}