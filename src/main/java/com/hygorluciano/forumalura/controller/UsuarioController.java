package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.usuarios.dto.*;
import com.hygorluciano.forumalura.domain.usuarios.models.*;
import com.hygorluciano.forumalura.domain.usuarios.repository.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public ResponseEntity postUsuario(@RequestBody @Valid UsuarioPostDto usuarioPostDto){
        var newUsuario = new Usuario(usuarioPostDto);
        System.out.println(newUsuario);
        usuarioRepository.save(newUsuario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
    }
    
}
