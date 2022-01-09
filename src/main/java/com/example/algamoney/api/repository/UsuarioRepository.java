package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
