package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.usuarios.dto.*;
import com.hygorluciano.forumalura.domain.usuarios.interfaces.CrudUsuarios;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    private final CrudUsuarios crudUsuarios;

    @Autowired
    public UsuarioController(CrudUsuarios crudUsuarios) {
        this.crudUsuarios = crudUsuarios;
    }

    @PostMapping("/registra")
    public ResponseEntity<HttpStatus> postUsuario(@RequestBody @Valid UsuarioPostDto usuarioPostDto) {
        return crudUsuarios.criaUsuario(usuarioPostDto);
    }

    @PostMapping
    public ResponseEntity<LoginDto> postUsuario(@RequestBody @Valid LoginUsuarioDto dados) {
        return crudUsuarios.loginUsusario(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosUsuariosDTO>> listaUsuario() {
        return crudUsuarios.listaUsuarios();
    }

    @PutMapping("/registra/atualizar")
    @Transactional
    public ResponseEntity<HttpStatus> atualizarUsuario(@RequestBody @Valid AtualizarUsuarioDto dados) {
        return crudUsuarios.atualizarUsuario(dados);
    }
}
