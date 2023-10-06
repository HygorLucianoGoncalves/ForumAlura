package com.hygorluciano.forumalura.domain.interfaces;

import com.hygorluciano.forumalura.domain.dtos.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudTopico {
    ResponseEntity<HttpStatus> criaTopico(TopicosPostDTO dados);

    ResponseEntity<Page<TopicoSemRespostaDTO>> mostraTopicos();

    List<TopicoDetalhamnetoDTO> mostraTopicoComRespostas(String id);

    ResponseEntity<Topico> atualizarTopico(TopicoPutDTO topicoPutDTO);

    ResponseEntity<Topico> deleteTopico(String id);
}
