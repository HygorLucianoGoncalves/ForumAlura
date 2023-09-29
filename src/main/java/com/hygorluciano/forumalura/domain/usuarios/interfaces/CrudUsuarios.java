package com.hygorluciano.forumalura.domain.usuarios.interfaces;

import com.hygorluciano.forumalura.domain.usuarios.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudUsuarios {
    ResponseEntity<LoginDto> loginUsusario(LoginUsuarioDto dados);

    ResponseEntity<HttpStatus> criaUsuario(UsuarioPostDto dados);

    ResponseEntity<List<DadosUsuariosDTO>> listaUsuarios();

    ResponseEntity<HttpStatus> atualizarUsuario(AtualizarUsuarioDto dados);
}
