package org.fatec.les.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class PedidoEntity {
 
	@Id
	@GeneratedValue
	private Long id;
	
	private Date data;
	
	@OneToOne
	private EnderecoEntity endereco;
	
	@ManyToOne
	private ClienteEntity cliente;
	
	private Boolean status;
	
	private Double valor = 0.0;
	
	private Integer quantidade;
	
	@Transient
	private List<CamisetaEntity> camisetas;
	
	
	public PedidoEntity() {
		camisetas = new ArrayList<CamisetaEntity>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void addCamiseta(CamisetaEntity novaCamiseta){
		valor += novaCamiseta.getPreco();
		camisetas.add(novaCamiseta);
		getValor();
	}
	
	public List<CamisetaEntity> getCamisetas() {
		return camisetas;
	}

	public void setCamisetas(List<CamisetaEntity> camisetas) {
		this.camisetas = camisetas;
	}

	public void rmCamiseta(CamisetaEntity camiseta){
		valor -= camiseta.getPreco();
		camisetas.remove(camiseta);
		getValor();
	}
	
}

