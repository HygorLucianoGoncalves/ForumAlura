package com.hygorluciano.forumalura.domain.usuarios.repository;

import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
