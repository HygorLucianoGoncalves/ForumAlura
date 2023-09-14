package com.hygorluciano.forumalura.domain.usuarios.service;

import com.hygorluciano.forumalura.domain.usuarios.dto.*;
import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import com.hygorluciano.forumalura.infra.security.TokenService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CrudUsuarios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity loginUsusario(LoginUsuarioDto dados) {

        var usuarioESenha = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = this.authenticationManager.authenticate(usuarioESenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDto(token));
    }

    public ResponseEntity criaUsuario(UsuarioPostDto dados) {

        try {

            if (this.usuarioRepository.findByEmail(dados.email()) != null) return ResponseEntity.badRequest().build();
            String senhaEncrypted = new BCryptPasswordEncoder().encode(dados.senha());
            // Cria um novo tópico com os dados fornecidos
            var newUsuario = new Usuario(dados.nome(), dados.email(), senhaEncrypted, dados.role());

            // Salva o novo tópico no repositório
            usuarioRepository.save(newUsuario);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new CriacaoInvalidoException();
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
