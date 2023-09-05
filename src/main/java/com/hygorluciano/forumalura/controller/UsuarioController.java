package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.usuarios.Usuario;
import com.hygorluciano.forumalura.domain.usuarios.UsuarioPostDto;
import com.hygorluciano.forumalura.domain.usuarios.UsuarioRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/register")
    public ResponseEntity postUsuario(@RequestBody @Valid UsuarioPostDto usuarioPostDto){
        var newUsuario = new Usuario(usuarioPostDto);
        System.out.println(newUsuario);
        usuarioRepository.save(newUsuario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
    }
    
}
