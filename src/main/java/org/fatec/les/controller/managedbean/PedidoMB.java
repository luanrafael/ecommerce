package org.fatec.les.controller.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.fatec.les.controller.utils.jsfUtils;
import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.model.entity.PedidoEntity;
import org.fatec.les.repositorio.PedidoRepositorio;

@ManagedBean
@ViewScoped
public class PedidoMB implements Serializable {

	private PedidoEntity pedido;
	
    private List<CamisetaEntity> camisetas;
	
	
	public PedidoMB() {
		pedido = new PedidoEntity();
		setCamisetas(new ArrayList<CamisetaEntity>());
	}
	
	public PedidoEntity getPedidoEntity() {
		return this.pedido;
	}
	
	public void setPedidoEntity(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	
	public void actionCadastrarPedido() {
		PedidoRepositorio repositorio = new PedidoRepositorio();
		repositorio.persist(pedido);
		jsfUtils.addInfo("Pedido inserido com sucesso");
	}

	public List<CamisetaEntity> getCamisetas() {
		return camisetas;
	}

	public void setCamisetas(List<CamisetaEntity> camisetas) {
		this.camisetas = camisetas;
	}
	  
}
