package com.hygorluciano.forumalura.domain.repositorys;

import com.hygorluciano.forumalura.domain.model.Resposta;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, String> {
}
