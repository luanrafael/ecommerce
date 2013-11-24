package org.fatec.les.controller.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.fatec.les.model.entity.CamisetaEntity;

public class CarrinhoMB implements Serializable {

	private List<CamisetaEntity> CamisetaEntitys;

	private CamisetaEntity selectedCamisetaEntity;

	public CarrinhoMB() {
		CamisetaEntitys = new ArrayList<CamisetaEntity>();
	}

	public CamisetaEntity getSelectedCamisetaEntity() {
		return selectedCamisetaEntity;
	}

	public void setSelectedCamisetaEntity(CamisetaEntity selectedCamisetaEntity) {
		this.selectedCamisetaEntity = selectedCamisetaEntity;
	}

	public List<CamisetaEntity> getCamisetaEntitys() {
		return CamisetaEntitys;
	}

}
