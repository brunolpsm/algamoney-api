package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.modelo.Usuario;
import com.example.algamoney.api.repository.UsuarioRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuarios")
@Api(value = "Usuários")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping
	private ResponseEntity<List<Usuario>> buscarTodos() {

		List<Usuario> listaUsuarios = usuarioRepository.findAll();

		return listaUsuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaUsuarios);
	}

	@PostMapping
	private Usuario criar() {

		return new Usuario();
	}

}
