package org.fatec.les.controller.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
