package org.fatec.les.model.entity;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

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
	
	public String getImg() {
		if(imagem != null){
			BufferedImage buffer = null; 
									
			try {
				buffer = ImageIO.read(new ByteArrayInputStream(imagem));
				
				img = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\Temp\\"+idCamiseta+".jpg";
				ImageIO.write(buffer, "JPG", new File(img));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Transient
	private String img;
	
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

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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