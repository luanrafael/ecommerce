package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.model.entity.PedidoEntity;
import org.fatec.les.repositorio.CamisetaRepositorio;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class PedidoMB implements Serializable {

	private PedidoEntity pedido;
	private Long id;
	private CamisetaEntity camisetaEntity;
	
	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public PedidoMB() {
		pedido = new PedidoEntity();
	}
	
	public PedidoEntity getPedidoEntity() {
		return this.pedido;
	}
	
	public void setPedidoEntity(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	
	public void addToCar(){ 
		pedido.addCamiseta(camisetaEntity);
		RequestContext.getCurrentInstance().update("form");
	}
	
	public CamisetaEntity getCamisetaEntity() {
		return camisetaEntity;
	}

	public void setCamisetaEntity(CamisetaEntity camisetaEntity) {
		this.camisetaEntity = camisetaEntity;
	}

	public void removeFromTheCar(){
		pedido.rmCamiseta(camisetaEntity);
	}
	
	public void abrirCamiseta(){
		CamisetaRepositorio camisetaRepositorio = new CamisetaRepositorio();
		camisetaEntity = camisetaRepositorio.load(id);
		try {
			jsfUtils.redirecionar("view/pedido/novoPedido.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionComprar(){
		try {
			jsfUtils.redirecionar("view/pedido/carrinhoDeCompras.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
