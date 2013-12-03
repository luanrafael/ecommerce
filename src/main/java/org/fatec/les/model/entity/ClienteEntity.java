package org.fatec.les.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.fatec.les.model.utils.Criptografia;

import com.timgroup.jgravatar.Gravatar;


@Entity
public class ClienteEntity implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@Column(unique=true)
	private String email;
	private String email_alternativo;
	
	@Column(unique=true)
	private String cpf;
	private String telefone;
	private String celular;
	private String senha;	
	private String urlGravatar;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	@OneToOne(cascade=CascadeType.ALL)
	private EnderecoEntity endereco;
	
	
	public ClienteEntity() {

	}
	
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

	
	public void setSenha( String senha) {
		this.senha = Criptografia.criptografar(senha);
	}

	public String getNome() {
		return nome;
	}
	
	public void setEndereco(EnderecoEntity endereco){
		this.endereco = endereco;
	}
	
	public EnderecoEntity getEndereco(){
		return endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void setAll(String nome, String email, String emailAternativo,String senha, String cpf, String telefone, String celular, Date data, EnderecoEntity endereco){
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setData_nascimento(data);
		setEndereco(endereco);
		setEmail_alternativo(emailAternativo);
	}

	public String getUrlGravatar() {
		return this.urlGravatar;
	}

	public void setUrlGravatar(String urlGravatar) {
		this.urlGravatar = verificaGravatar(urlGravatar);
	}
	
	public String verificaGravatar(String url){
		Gravatar gravatar = new Gravatar();
		String retorno = null;
		if (gravatar.download(url) == null){
			retorno = "/view/template/img/user.png";
		} else {
			retorno = gravatar.getUrl(url);
		}
		return retorno;
	}
}
