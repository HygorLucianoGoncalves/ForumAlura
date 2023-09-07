package com.hygorluciano.forumalura.domain.topicos.service;

import com.hygorluciano.forumalura.domain.cursos.models.Curso;
import com.hygorluciano.forumalura.domain.cursos.repository.CursoRepository;
import com.hygorluciano.forumalura.domain.resposta.dto.RespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.PesquisaTopicosById;
import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoDetalhamnetoDto;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDto;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.usuarios.models.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.ResquestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudTopico {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicosRespository topicosRespository;

    public ResponseEntity criaTopico(TopicosPostDto dados) {
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

    public List<TopicoDetalhamnetoDto> mostraTopicoComRespostas(String id) {
        Optional<Topico> topicoOptional = topicosRespository.findById(id);

        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();

            List<RespostaDTO> respostasDto = topico.getRespostas()
                    .stream()
                    .map(resposta -> new RespostaDTO(
                            resposta.getMensagem(),
                            resposta.getAutor().getNome(), // o nome do autor
                            resposta.getDataCriacao(),
                            resposta.getSolucao()
                    ))
                    .collect(Collectors.toList());

            // Mapeie o tópico e inclua as respostas mapeadas
            List<TopicoDetalhamnetoDto> dtos = List.of(new TopicoDetalhamnetoDto(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensagem(),
                    topico.getDataCriacao(),
                    topico.getStatus(),
                    topico.getAutor().getNome(),
                    topico.getCurso().getCategoria(),
                    respostasDto // Inclui os RespostaDTO no DTO do tópico
            ));

            return dtos;
        } else {
            // Trate o caso em que o tópico não foi encontrado com base no ID
            throw new RuntimeException("Tópico não encontrado com o ID fornecido");        }
    }


    //public ResponseEntity atualizarTopico(){}


}
