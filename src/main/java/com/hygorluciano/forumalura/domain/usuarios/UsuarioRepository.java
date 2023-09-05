package com.hygorluciano.forumalura.domain.usuarios;

import com.hygorluciano.forumalura.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
