package org.fatec.les.service;

import java.util.List;

import org.fatec.les.model.entity.PedidoEntity;
import org.fatec.les.repositorio.PedidoRepositorio;

public class PedidoService {

private PedidoRepositorio repositorio;
	
	public void inserirPedido(PedidoEntity pedido) {
		repositorio.persist(pedido);
	}
	
	public void deletar(PedidoEntity pedido) {
		repositorio.deleteById(pedido.getId());
	}
	
	public PedidoEntity buscarPedido(Long id) {
		PedidoEntity pedido = repositorio.load(id);
		return pedido;
	}
	
	public List<PedidoEntity> buscarTodos() {
		List<PedidoEntity> pedidos = repositorio.loadAll();
		return pedidos;
	}
}
