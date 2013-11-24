package org.ftec.les.test;

import org.fatec.les.model.entity.CamisetaEntity;
import org.fatec.les.model.entity.FornecedorEntity;
import org.fatec.les.model.enuns.MarcaEnum;
import org.fatec.les.model.enuns.TamanhoEnum;
import org.fatec.les.model.enuns.TimeEnum;
import org.fatec.les.repositorio.CamisetaRepositorio;
import org.junit.Before;
import org.junit.Test;

public class CamisetaTest {
	
	private CamisetaEntity camiseta;

	
	@Before
	public void initTest(){

	}
	
	@Test
	public void cadastrarCamiseta(){
		camiseta = new CamisetaEntity();		
		camiseta.setDescricao("camiseta teste");
		camiseta.setMarca(MarcaEnum.NIKE);
		camiseta.setModelo("padrao");
		camiseta.setQuantidadeEmEstoque(10);
		camiseta.setTamanho(TamanhoEnum.M);
		camiseta.setTime(TimeEnum.CORINTHIANS);
		
		CamisetaRepositorio repositorio = new CamisetaRepositorio();
		
		repositorio.persist(camiseta);
	}
	

}