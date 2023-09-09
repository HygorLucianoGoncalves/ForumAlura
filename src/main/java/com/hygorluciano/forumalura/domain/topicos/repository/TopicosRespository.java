package com.hygorluciano.forumalura.domain.topicos.repository;

import com.hygorluciano.forumalura.domain.topicos.model.Topico;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TopicosRespository extends JpaRepository<Topico,String> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

}

