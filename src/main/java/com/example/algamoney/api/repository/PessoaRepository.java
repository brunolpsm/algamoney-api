package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
