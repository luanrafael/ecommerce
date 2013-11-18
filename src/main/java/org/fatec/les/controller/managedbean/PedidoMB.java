package org.fatec.les.controller.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.fatec.les.controller.util.MsgUtil;
import org.fatec.les.model.entity.PedidoEntity;
import org.fatec.les.repositorio.PedidoRepositorio;

@ManagedBean
@ViewScoped
public class PedidoMB implements Serializable {

	private PedidoEntity pedido;
	
	public PedidoMB() {
		pedido = new PedidoEntity();
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
		MsgUtil.addInfo("Pedido inserido com sucesso");
	}
	
}
