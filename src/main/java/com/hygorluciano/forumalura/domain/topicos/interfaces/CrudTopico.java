package com.hygorluciano.forumalura.domain.topicos.interfaces;

import com.hygorluciano.forumalura.domain.topicos.dto.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.topicos.model.Topico;
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
