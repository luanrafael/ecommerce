package org.fatec.les.model.entity;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
	
	private Double preco;

	@Transient
	private StreamedContent fileContent;
	
	@Lob
	private byte[] imagem;
			
	public StreamedContent getFileContent() {
		return getInputImage();
	}
	
	public void setFileContent(StreamedContent fileContent) {
		this.fileContent = fileContent;
	}

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

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	//	IMAGE
	public StreamedContent getInputImage() {

		if (imagem != null) {
			if (imagem.length != 0) {
				return new DefaultStreamedContent(new ByteArrayInputStream(imagem), "image/jpg",idCamiseta +".jpg");
			} else {
				return new DefaultStreamedContent();
			}
		} else {
			return new DefaultStreamedContent();
		}
	}
	
	
	public boolean hasNulo(String msg){
		msg = "Favor preencher o campo ";
		if(this.marca == null){
			msg += "marca";
			return false;
		}
		if(this.time == null){
			msg += "time";
			return false;
		}
		if(this.tamanho == null){
			msg += "tamanho";
			return false;
		}
		if(this.quantidadeEmEstoque <= 0){
			msg = "O campo Quantidade não pode ser igual ou menor que 0";
			return false;
		}
		if(this.preco <= 0){
			msg = "O campo Preço não pode ser igual ou menor que 0";
			return false;
		}
		return true;
	}
}