package org.fatec.les.model.usuario;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private String email_alternativo;
	private String cpf;
	private String telefone;
	private String celular;
	private String senha;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_alternativo() {
		return email_alternativo;
	}

	public void setEmail_alternativo(String email_alternativo) {
		this.email_alternativo = email_alternativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public Endereco getEndereco(){
		return endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
