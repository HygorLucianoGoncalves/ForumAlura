package com.hygorluciano.forumalura.domain.topicos;

import com.hygorluciano.forumalura.domain.topicos.Topico;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TopicosRespository extends JpaRepository<Topico,String> {
}
