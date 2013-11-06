package org.fatec.les.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.fatec.les.model.enuns.MarcaEnum;
import org.fatec.les.model.enuns.ModeloEnum;
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
	private ModeloEnum modelo;
	
	@Column(unique=true, length=60)
	private String descricao;

	private int quantidadeEmEstoque;
	private Double preco;
	
	@ManyToOne
	private UsuarioEntity usuario;
	
	//TODO: inserir dependencia de FORNECEDOR
	
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
	public ModeloEnum getModelo() {
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
	public void setModelo(ModeloEnum modelo) {
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}	
