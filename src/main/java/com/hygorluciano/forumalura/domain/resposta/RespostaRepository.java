package com.hygorluciano.forumalura.domain.resposta;

import com.hygorluciano.forumalura.domain.resposta.Resposta;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, String> {
}
