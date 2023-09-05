package com.hygorluciano.forumalura.domain.topicos;

import com.hygorluciano.forumalura.domain.cursos.CursoRepository;
import com.hygorluciano.forumalura.domain.resposta.RespostaRepository;
import com.hygorluciano.forumalura.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriacaoDeTopico {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private TopicosRespository topicosRespository;

    public TopicoDetalhamnetoDto criaTopico(TopicosPostDto dados){
        var autor = usuarioRepository.getReferenceById(dados.autor());
        var curso = cursoRepository.getReferenceById(dados.curso());

        var newTopico = new Topico(
                null,
                dados.titulo(),
                dados.mensagem(),
                null,
                null,
                autor,
                curso,
                null
        );
        topicosRespository.save(newTopico);
        return  new TopicoDetalhamnetoDto(newTopico);
    }



}
