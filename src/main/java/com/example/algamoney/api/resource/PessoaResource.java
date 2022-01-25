package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.modelo.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pessoas")
@Api(value = "Pessoa", hidden = false)
public class PessoaResource {

	@Autowired
	PessoaRepository pessoaRepository;

	@ApiOperation(value = "Consulta todas as pessoas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Pessoa>> readAll() {
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		return listaPessoas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaPessoas);
	}

	@ApiOperation(value = "Consulta uma pessoa por id")
	@GetMapping(value = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Pessoa> read(@PathVariable Long codigo) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);
		return pessoa.isPresent() ? ResponseEntity.ok(pessoa.get()) : ResponseEntity.noContent().build();
	}

	@PostMapping
	@ApiOperation(value = "Cria uma pessoa")
	@ResponseStatus(code = HttpStatus.CREATED)
	@GetMapping(value = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(pessoaSalva);
	}

}
