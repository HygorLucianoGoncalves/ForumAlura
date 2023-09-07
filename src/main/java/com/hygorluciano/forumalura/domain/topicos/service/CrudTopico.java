package com.hygorluciano.forumalura.domain.topicos.service;

import com.hygorluciano.forumalura.domain.cursos.models.Curso;
import com.hygorluciano.forumalura.domain.cursos.repository.CursoRepository;
import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import com.hygorluciano.forumalura.domain.resposta.dto.RespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoDetalhamnetoDto;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDto;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.usuarios.models.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudTopico {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicosRespository topicosRespository;

    public ResponseEntity criaTopico(TopicosPostDto dados){
        // Obtém as referências para o autor e o curso a partir dos repositórios
        Usuario autor = usuarioRepository.getReferenceById(dados.autor());
        Curso curso = cursoRepository.getReferenceById(dados.curso());

        // Cria um novo tópico com os dados fornecidos
        Topico newTopico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                autor,
                curso);

        // Salva o novo tópico no repositório
        topicosRespository.save(newTopico);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public  List<TopicoDetalhamnetoDto> mostraTopico(){
        var topicos = topicosRespository.findAll();

        List<TopicoDetalhamnetoDto> dtos = topicos
                .stream()
                .map(topico -> {
                    // Mapear as respostas da entidade Resposta para RespostaDTO
                    List<RespostaDTO> respostasDto = topico.getRespostas()
                            .stream()
                            .map(resposta -> new RespostaDTO(
                                    resposta.getMensagem(),
                                    resposta.getDataCriacao(),
                                    resposta.getAutor().getNome(), //  o nome do autor
                                    resposta.getSolucao()
                            ))
                            .collect(Collectors.toList());

                    // Mapear o tópico e incluir as respostas mapeadas
                    return new TopicoDetalhamnetoDto(
                            topico.getId(),
                            topico.getTitulo(),
                            topico.getMensagem(),
                            topico.getDataCriacao(),
                            topico.getStatus(),
                            topico.getAutor().getNome(),
                            topico.getCurso().getCategoria(),
                            respostasDto // Inclui os RespostaDTO no DTO do tópico
                    );
                })
                .collect(Collectors.toList());



        return dtos;
    }

    //public ResponseEntity atualizarTopico(){}



}
