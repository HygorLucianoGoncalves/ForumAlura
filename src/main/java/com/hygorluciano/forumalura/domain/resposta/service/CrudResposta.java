package com.hygorluciano.forumalura.domain.resposta.service;

import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import com.hygorluciano.forumalura.domain.resposta.dto.CriacaoDeRespostaDto;
import com.hygorluciano.forumalura.domain.resposta.model.Resposta;
import com.hygorluciano.forumalura.domain.resposta.repository.RespostaRepository;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudResposta {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private TopicosRespository topicosRespository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity criaResposta (CriacaoDeRespostaDto dados){

        try {
            // Obtém as referências para o autor e o curso a partir dos repositórios
            var topico = topicosRespository.getReferenceById(dados.topico());
            var autor = usuarioRepository.getReferenceById(dados.autor());

            // Cria um novo tópico com os dados fornecidos
            var newResposta = new Resposta(
                    dados.mensagem(),
                    topico,
                    autor
            );

            // Salva o novo tópico no repositório
            respostaRepository.save(newResposta);

            return  ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new CriacaoInvalidoException("Valores ja existe");
        }
    }

    public ResponseEntity listaResposta(){

        var repostas = respostaRepository.findAll();

        List<DadosRespostaDTO> dtos = repostas.stream()
                .map(resposta -> new DadosRespostaDTO(
                        resposta.getId(),
                        resposta.getMensagem(),
                        resposta.getTopico().getId(),
                        resposta.getDataCriacao(),
                        resposta.getAutor().getNome(),
                        resposta.getSolucao()
                ))
                .toList();

        return ResponseEntity.ok(dtos);
    }

}
