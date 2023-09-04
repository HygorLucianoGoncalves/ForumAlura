package com.hygorluciano.forumalura.domain.resposta;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, String> {
}
