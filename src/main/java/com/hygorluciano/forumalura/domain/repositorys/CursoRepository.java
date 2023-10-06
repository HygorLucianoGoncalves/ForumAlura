package com.hygorluciano.forumalura.domain.repositorys;

import com.hygorluciano.forumalura.domain.model.Curso;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}
