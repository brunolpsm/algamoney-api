package com.example.algamoney.api.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pessoa", schema = "algamoneyapi")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@NotNull
	@Min(value = 3)
	@Max(value = 50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Email
	@Column(name = "email")
	private String email;

	@NotNull
	@Min(value = 11)
	@Max(value = 11)
	@Column(name = "telefone")
	private String telefone;

	@NotNull
	@Min(value = 11)
	@Max(value = 11)
	@Column(name = "cpf")
	private String cpf;

	public Pessoa() {
	}

	public Pessoa(Long codigo, String nome, String email, String telefone, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
