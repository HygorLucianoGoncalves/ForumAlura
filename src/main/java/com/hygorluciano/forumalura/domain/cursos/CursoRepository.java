package com.hygorluciano.forumalura.domain.cursos;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}
