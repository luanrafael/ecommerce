package org.fatec.les.repositorio;

import java.util.List;

import org.fatec.les.model.entity.CamisetaEntity;

public class CamisetaRepositorio extends BaseRepositorio<CamisetaEntity> {

public List<CamisetaEntity> buscarCamisetasPorTime(String time){
		
		String sql = "select c from CamisetaEntity c where time = ?1";
		return entityManager.createQuery(sql).setParameter(1, time).getResultList();			
	}
	
}
