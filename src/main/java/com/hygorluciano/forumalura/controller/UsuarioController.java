package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.usuarios.dto.AtualizarUsuarioDto;
import com.hygorluciano.forumalura.domain.usuarios.dto.LoginUsuarioDto;
import com.hygorluciano.forumalura.domain.usuarios.dto.UsuarioPostDto;
import com.hygorluciano.forumalura.domain.usuarios.repository.UsuarioRepository;
import com.hygorluciano.forumalura.domain.usuarios.service.CrudUsuarios;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private CrudUsuarios crudUsuarios;

    @PostMapping("/registra")
    public ResponseEntity postUsuario(@RequestBody @Valid UsuarioPostDto usuarioPostDto) {return crudUsuarios.criaUsuario(usuarioPostDto);}

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody @Valid LoginUsuarioDto dados) {return crudUsuarios.loginUsusario(dados);}

    @GetMapping
    public ResponseEntity listaUsuario() {
        return crudUsuarios.listaUsuarios();
    }

    @PutMapping("/registra/atualizar")
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody @Valid AtualizarUsuarioDto dados) {return crudUsuarios.atualizarUsuario(dados);}
}
