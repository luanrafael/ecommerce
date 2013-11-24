package org.fatec.les.controller.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

<<<<<<< HEAD
import org.fatec.les.controller.utils.jsfUtils;
=======
import org.fatec.les.controller.utils.MsgUtil;
import org.fatec.les.model.entity.CamisetaEntity;
>>>>>>> f714e38e6c85c68a660d9078359006a48fb92f0a
import org.fatec.les.model.entity.PedidoEntity;
import org.fatec.les.repositorio.PedidoRepositorio;
import java.util.ArrayList;  
import java.util.List;  

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
