package com.upn.wa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upn.wa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
