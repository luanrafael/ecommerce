package org.fatec.les.repositorio;

import java.util.List;

import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.model.enuns.TimeEnum;

public class CamisetaRepositorio extends BaseRepositorio<CamisetaEntity> {

	public List<CamisetaEntity> buscarPorTime(TimeEnum time) {
		String sql = "select from CamisetaEntity c where c.TimeEnum = ?1";
		return entityManager.createQuery(sql).setParameter(1, time).getResultList();
	}

	public List<CamisetaEntity> buscarPorPreco(Double preco) {
		String sql = "select from CamisetaEntity c where c.preco = ?1";
		return entityManager.createQuery(sql).setParameter(1, preco).getResultList();
	}
}
