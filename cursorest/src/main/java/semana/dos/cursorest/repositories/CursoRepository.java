package semana.dos.cursorest.repositories;

import semana.dos.cursorest.models.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
    List<Curso> findByPrecioBetween(@PathVariable("minPrecio") int minPrecio, @PathVariable("maxPrecio") int maxPrecio);
}
