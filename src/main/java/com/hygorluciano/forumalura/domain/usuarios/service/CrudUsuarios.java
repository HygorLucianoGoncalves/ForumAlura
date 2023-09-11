package com.hygorluciano.forumalura.domain.usuarios.service;

import com.hygorluciano.forumalura.domain.usuarios.dto.AtualizarUsuarioDto;
import com.hygorluciano.forumalura.domain.usuarios.dto.DadosUsuariosDTO;
import com.hygorluciano.forumalura.domain.usuarios.dto.UsuarioPostDto;
import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudUsuarios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity criaUsuario(UsuarioPostDto dados) {

        try {
            // Cria um novo tópico com os dados fornecidos
            var newUsuario = new Usuario(dados);

            // Salva o novo tópico no repositório
            usuarioRepository.save(newUsuario);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new CriacaoInvalidoException("Valores ja existe");
        }
    }

    public ResponseEntity listaUsuarios() {
        //Faz lista de Todos os usuarios
        var usuarios = usuarioRepository.findAll();

        // Converta a lista de usuarios em uma lista de registros DadosUsuariosDTO
        List<DadosUsuariosDTO> dtos = usuarios.stream()
                .map(usuario -> new DadosUsuariosDTO(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity atualizarUsuario(AtualizarUsuarioDto dados) {
        //Pega um usuario pelo o id, e retorna um Optional dele
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(dados.id());

        //Ser optionalUsuario estiver presente ou com valor, atualizar as dados com os dados recebido de dados
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(dados.nome());
            usuario.setEmail(dados.email());
            usuario.setSenha(dados.senha());
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
