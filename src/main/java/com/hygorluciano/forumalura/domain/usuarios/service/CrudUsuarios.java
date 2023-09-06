package com.hygorluciano.forumalura.domain.usuarios.service;

import com.hygorluciano.forumalura.domain.usuarios.dto.AtualizarUsuarioDto;
import com.hygorluciano.forumalura.domain.usuarios.dto.DadosUsuariosDTO;
import com.hygorluciano.forumalura.domain.usuarios.dto.UsuarioPostDto;
import com.hygorluciano.forumalura.domain.usuarios.models.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudUsuarios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity criaUsuario(UsuarioPostDto dados) {
        var newUsuario = new Usuario(dados);
        usuarioRepository.save(newUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity listaUsuarios() {
        var usuarios = usuarioRepository.findAll();
        List<DadosUsuariosDTO> dtos = usuarios.stream()
                .map(usuario -> new DadosUsuariosDTO(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity atualizarUsuario(AtualizarUsuarioDto dados) {
        Optional<Usuario> optionalProduct = usuarioRepository.findById(dados.id());
        if (optionalProduct.isPresent()) {
            Usuario usuario = optionalProduct.get();
            usuario.setNome(dados.nome());
            usuario.setEmail(dados.email());
            usuario.setSenha(dados.senha());
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
