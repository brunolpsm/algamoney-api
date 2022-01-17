package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.modelo.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pessoas")
@Api(value = "pessoa")
public class PessoaResource {

	@Autowired
	PessoaRepository PessoaRepository;

	@GetMapping
	private ResponseEntity<List<Pessoa>> buscarTodos() {

		List<Pessoa> listaPessoas = PessoaRepository.findAll();

		return listaPessoas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaPessoas);
	}

	@PostMapping
	private void criar() {

	}

}
