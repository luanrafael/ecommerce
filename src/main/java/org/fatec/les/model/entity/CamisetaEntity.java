package org.fatec.les.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.fatec.les.model.enuns.MarcaEnum;
import org.fatec.les.model.enuns.TamanhoEnum;
import org.fatec.les.model.enuns.TimeEnum;

@Entity
public class CamisetaEntity {
	 
	@Id
	@GeneratedValue
	private Long idCamiseta;
	
	private MarcaEnum Marca;
	
	private TamanhoEnum Tamanho;
	
	private TimeEnum Time;
	
	private String descricao;
	private String modelo;
	private int quantidadeEmEstoque;
			
	public Long getIdCamiseta() {
		return idCamiseta;
	}
	
	public MarcaEnum getMarca() {
		return Marca;
	}

	public TamanhoEnum getTamanho() {
		return Tamanho;
	}

	public TimeEnum getTime() {
		return Time;
	}

	public void setMarca(MarcaEnum marca) {
		Marca = marca;
	}

	public void setTamanho(TamanhoEnum tamanho) {
		Tamanho = tamanho;
	}


	public void setTime(TimeEnum time) {
		Time = time;
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

}