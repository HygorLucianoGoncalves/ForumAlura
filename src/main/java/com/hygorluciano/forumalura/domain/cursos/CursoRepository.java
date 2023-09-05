package com.hygorluciano.forumalura.domain.cursos;

import com.hygorluciano.forumalura.domain.cursos.Curso;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}
