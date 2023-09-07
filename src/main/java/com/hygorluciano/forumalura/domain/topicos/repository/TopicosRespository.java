package com.hygorluciano.forumalura.domain.topicos.repository;

import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface TopicosRespository extends JpaRepository<Topico,String> {
}
