package com.hygorluciano.forumalura.domain.usuarios.repository;

import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    UserDetails findByEmail(String emial);
}
