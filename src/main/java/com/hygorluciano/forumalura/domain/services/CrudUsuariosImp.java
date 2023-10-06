package com.hygorluciano.forumalura.domain.services;

import com.hygorluciano.forumalura.domain.dtos.*;
import com.hygorluciano.forumalura.domain.interfaces.CrudUsuarios;
import com.hygorluciano.forumalura.domain.model.Usuario;
import com.hygorluciano.forumalura.domain.repositorys.UsuarioRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import com.hygorluciano.forumalura.infra.security.TokenService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CrudUsuariosImp implements CrudUsuarios {

    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @Autowired
    public CrudUsuariosImp(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<UsuarioTokenDto> loginUsusario(UsuarioLoginDto dados) {
        var usuarioESenha = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        var auth = this.authenticationManager.authenticate(usuarioESenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new UsuarioTokenDto(token));
    }

    @Override
    public ResponseEntity<HttpStatus> criaUsuario(UsuarioPostDto dados) {
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

    @Override
    public ResponseEntity<List<UsuariosDto>> listaUsuarios() {

        //Faz lista de Todos os usuarios
        var usuarios = usuarioRepository.findAll();

        // Converta a lista de usuarios em uma lista de registros DadosUsuariosDTO
        List<UsuariosDto> dtos = usuarios.stream()
                .map(usuario -> new UsuariosDto(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<HttpStatus> atualizarUsuario(UsuarioPutDto dados) {

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
