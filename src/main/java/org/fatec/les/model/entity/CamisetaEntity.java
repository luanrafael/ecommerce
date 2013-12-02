package org.fatec.les.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CamisetaEntity implements Serializable{
	 
	@Id
	@GeneratedValue
	private Long idCamiseta;
	
	private String marca;
	private String tamanho;
	private String time;	
	
	private String descricao;
	private String modelo;
	private int quantidadeEmEstoque;
	
	@Lob
	private byte[] imagem;
			
	public Long getIdCamiseta() {
		return idCamiseta;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMarca() {
		return marca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public String getTime() {
		return time;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}