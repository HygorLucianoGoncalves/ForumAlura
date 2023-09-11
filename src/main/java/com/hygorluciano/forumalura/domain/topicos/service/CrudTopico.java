package com.hygorluciano.forumalura.domain.topicos.service;

import com.hygorluciano.forumalura.domain.cursos.model.Curso;
import com.hygorluciano.forumalura.domain.cursos.repository.CursoRepository;
import com.hygorluciano.forumalura.domain.resposta.dto.RespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.model.Topico;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.IdInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public ResponseEntity<Topico> criaTopico(TopicosPostDTO dados) {

        // Verifica se já existe um tópico com o mesmo título e mensagem
        boolean topicoExistente = topicosRespository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if (topicoExistente) {
            // Retorne uma resposta de erro, por exemplo, com status 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Obtém as referências para o autor e o curso a partir dos repositórios
        Usuario autor = usuarioRepository.getReferenceById(dados.autor());
        Curso curso = cursoRepository.getReferenceById(dados.curso());

        // Cria um novo tópico com os dados fornecidos
        Topico newTopico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                autor,
                curso
        );

        // Salva o novo tópico no repositório
        topicosRespository.save(newTopico);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Page<TopicoSemRespostaDTO>> mostraTopicos(Pageable pageable){
        pageable = PageRequest.of(0, 10, Sort.by("dataCriacao").ascending());
        var page = topicosRespository.findAll(pageable).map((Topico id) -> new TopicoSemRespostaDTO(
                id.getTitulo(),
                id.getMensagem(),
                id.getDataCriacao(),
                id.getStatus(),
                id.getAutor().getNome(),
                id.getCurso().getNome()
                ));
        return ResponseEntity.ok(page);

    }

    public List<TopicoDetalhamnetoDTO> mostraTopicoComRespostas(String id) {
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
            List<TopicoDetalhamnetoDTO> dtos = List.of(new TopicoDetalhamnetoDTO(
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
            throw new IdInvalidoException("ID fornecido não encontrado");        }
    }

    public ResponseEntity<Topico> atualizarTopico(TopicoPutDTO topicoPutDTO) {
        // Obtém o tópico do banco de dados com base no id
        Optional<Topico> optionalTopico = topicosRespository.findById(topicoPutDTO.id());

        if (optionalTopico.isPresent()) {
            // Tópico encontrado, atualiza os dados
            Topico topico = optionalTopico.get();
            topico.setTitulo(topicoPutDTO.titulo());
            topico.setMensagem(topicoPutDTO.mensagem());
            topico.setStatus(topicoPutDTO.status());

            // Salva as alterações no banco de dados
            topicosRespository.save(topico);

            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            throw new IdInvalidoException("ID fornecido não encontrado");
        }
    }


    public  ResponseEntity<Topico> deleteTopico(String id){
        try {
            topicosRespository.deleteById(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new IdInvalidoException("ID fornecido não encontrado");
        }

    }

}
