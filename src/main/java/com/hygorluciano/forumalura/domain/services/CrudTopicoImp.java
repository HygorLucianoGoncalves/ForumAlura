package com.hygorluciano.forumalura.domain.services;

import com.hygorluciano.forumalura.domain.model.Curso;
import com.hygorluciano.forumalura.domain.repositorys.CursoRepository;
import com.hygorluciano.forumalura.domain.dtos.RespostaDto;
import com.hygorluciano.forumalura.domain.interfaces.CrudTopico;
import com.hygorluciano.forumalura.domain.dtos.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.model.Topico;
import com.hygorluciano.forumalura.domain.dtos.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.repositorys.TopicosRespository;
import com.hygorluciano.forumalura.domain.model.Usuario;
import com.hygorluciano.forumalura.domain.repositorys.UsuarioRepository;
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
public class CrudTopicoImp implements CrudTopico {

    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final TopicosRespository topicosRespository;

    @Autowired
    public CrudTopicoImp(UsuarioRepository usuarioRepository, CursoRepository cursoRepository, TopicosRespository topicosRespository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.topicosRespository = topicosRespository;
    }

    @Override
    public ResponseEntity<HttpStatus> criaTopico(TopicosPostDTO dados) {

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

    @Override
    public ResponseEntity<Page<TopicoSemRespostaDTO>> mostraTopicos() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("dataCriacao").ascending());
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

    @Override
    public List<TopicoDetalhamnetoDTO> mostraTopicoComRespostas(String id) {
        Optional<Topico> topicoOptional = topicosRespository.findById(id);

        if (topicoOptional.isPresent()) {

            Topico topico = topicoOptional.get();

            List<RespostaDto> respostasDto = topico.getRespostas()
                    .stream()
                    .map(resposta -> new RespostaDto(
                            resposta.getMensagem(),
                            resposta.getAutor().getNome(),
                            resposta.getDataCriacao(),
                            resposta.getSolucao()
                    ))
                    .collect(Collectors.toList());

            // Mapeie o tópico e inclua as respostas mapeadas

            return List.of(new TopicoDetalhamnetoDTO(
                    topico.getTitulo(),
                    topico.getMensagem(),
                    topico.getDataCriacao(),
                    topico.getStatus(),
                    topico.getAutor().getNome(),
                    topico.getCurso().getCategoria(),
                    respostasDto // Inclui os RespostaDTO no DTO do tópico
            ));
        } else {
            // Trate o caso em que o tópico não foi encontrado com base no ID
            throw new IdInvalidoException("ID fornecido não encontrado");
        }
    }

    @Override
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

    @Override
    public ResponseEntity<Topico> deleteTopico(String id) {
        try {
            topicosRespository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new IdInvalidoException("ID fornecido não encontrado");
        }

    }

}
