package org.fatec.les.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.fatec.les.model.enuns.MarcaEnum;
import org.fatec.les.model.enuns.TamanhoEnum;
import org.fatec.les.model.enuns.TimeEnum;
 
@Entity
public class CamisetaEntity {
	
	@Id
	@GeneratedValue
	private Long idCamiseta;
	private MarcaEnum marca;
	private TamanhoEnum tamanho;
	private TimeEnum time;
	private String descricao;
	private String modelo;
	private int quantidadeEmEstoque;
	
	@ManyToOne
	private FornecedorEntity fornecedor;
	
	@ManyToOne
	private UsuarioEntity usuario;
	
		
	public Long getIdCamiseta() {
		return idCamiseta;
	}
	public MarcaEnum getMarca() {
		return marca;
	}
	public TamanhoEnum getTamanho() {
		return tamanho;
	}
	public TimeEnum getTime() {
		return time;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getModelo() {
		return modelo;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setIdCamiseta(Long idCamiseta) {
		this.idCamiseta = idCamiseta;
	}
	public void setMarca(MarcaEnum marca) {
		this.marca = marca;
	}
	public void setTamanho(TamanhoEnum tamanho) {
		this.tamanho = tamanho;
	}
	public void setTime(TimeEnum time) {
		this.time = time;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}