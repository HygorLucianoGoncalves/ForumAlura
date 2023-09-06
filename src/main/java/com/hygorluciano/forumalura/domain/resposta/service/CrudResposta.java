package com.hygorluciano.forumalura.domain.resposta.service;

import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import com.hygorluciano.forumalura.domain.resposta.dto.CriacaoDeRespostaDto;
import com.hygorluciano.forumalura.domain.resposta.repository.RespostaRepository;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudResposta {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private TopicosRespository topicosRespository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosRespostaDTO criaResposta (CriacaoDeRespostaDto dados){
        var topico = topicosRespository.getReferenceById(dados.topico());
        var autor = usuarioRepository.getReferenceById(dados.autor());


        respostaRepository.save(newResposta);

        return new DadosRespostaDTO(newResposta);
    }

}
