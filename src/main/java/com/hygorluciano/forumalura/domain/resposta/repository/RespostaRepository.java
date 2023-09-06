package com.hygorluciano.forumalura.domain.resposta.repository;

import com.hygorluciano.forumalura.domain.resposta.models.Resposta;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, String> {
}