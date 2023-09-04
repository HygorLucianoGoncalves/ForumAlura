package com.hygorluciano.forumalura.domain.cursos.repository;

import com.hygorluciano.forumalura.domain.cursos.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}
