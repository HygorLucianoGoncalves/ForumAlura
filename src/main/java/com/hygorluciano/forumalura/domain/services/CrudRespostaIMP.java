package com.hygorluciano.forumalura.domain.services;

import com.hygorluciano.forumalura.domain.interfaces.CrudRespostas;
import com.hygorluciano.forumalura.domain.dtos.RespostaGetDto;
import com.hygorluciano.forumalura.domain.dtos.RespostaPostDto;
import com.hygorluciano.forumalura.domain.model.Resposta;
import com.hygorluciano.forumalura.domain.repositorys.RespostaRepository;
import com.hygorluciano.forumalura.domain.repositorys.TopicosRespository;
import com.hygorluciano.forumalura.domain.repositorys.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudRespostaIMP implements CrudRespostas {

    private final RespostaRepository respostaRepository;
    private final TopicosRespository topicosRespository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CrudRespostaIMP(RespostaRepository respostaRepository, TopicosRespository topicosRespository, UsuarioRepository usuarioRepository) {
        this.respostaRepository = respostaRepository;
        this.topicosRespository = topicosRespository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ResponseEntity<HttpStatus> criaResposta(RespostaPostDto dados) {

        try {
            // Obtém as referências para o autor e o curso a partir dos repositórios
            var topico = topicosRespository.getReferenceById(dados.topico());
            var autor = usuarioRepository.getReferenceById(dados.autor());

            // Cria um novo tópico com os dados fornecidos
            var newResposta = new Resposta(dados.mensagem(), topico, autor);

            // Salva o novo tópico no repositório
            respostaRepository.save(newResposta);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new CriacaoInvalidoException("Valores ja existe");
        }
    }

    @Override
    public ResponseEntity<List<RespostaGetDto>> listaResposta() {

        var repostas = respostaRepository.findAll();

        List<RespostaGetDto> dtos = repostas
                .stream()
                .map(
                        resposta -> new RespostaGetDto(
                                resposta.getId(),
                                resposta.getMensagem(),
                                resposta.getTopico().getId(),
                                resposta.getDataCriacao(),
                                resposta.getAutor().getNome(),
                                resposta.getSolucao()))
                .toList();

        return ResponseEntity.ok(dtos);
    }

    //    public ResponseEntity editarResposta(){
    //
    //    }

}
