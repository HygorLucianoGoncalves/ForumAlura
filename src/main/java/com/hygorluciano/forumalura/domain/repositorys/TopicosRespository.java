package com.hygorluciano.forumalura.domain.repositorys;

import com.hygorluciano.forumalura.domain.model.Topico;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TopicosRespository extends JpaRepository<Topico, String> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

}

