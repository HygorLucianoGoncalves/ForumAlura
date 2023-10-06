package com.hygorluciano.forumalura.domain.interfaces;

import com.hygorluciano.forumalura.domain.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudUsuarios {
    ResponseEntity<UsuarioTokenDto> loginUsusario(UsuarioLoginDto dados);

    ResponseEntity<HttpStatus> criaUsuario(UsuarioPostDto dados);

    ResponseEntity<List<UsuariosDto>> listaUsuarios();

    ResponseEntity<HttpStatus> atualizarUsuario(UsuarioPutDto dados);
}
