package org.ftec.les.test;

import java.util.Date;

import junit.framework.Assert;

import org.fatec.les.controller.managedbean.ClienteMB;
import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.entity.EnderecoEntity;
import org.fatec.les.repositorio.ClienteRepositorio;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	private ClienteEntity c;
	private EnderecoEntity e;
	
	private ClienteMB mb;
	
	@Before
	public void initTest(){
		c = new ClienteEntity();
		e = new EnderecoEntity();
		
		e.setAll("2", "bairro", 61, "cidade", "estado", "pais", "12319000");
		c.setAll("Luan", "luan@mail.com.br", "senha", "senha","123132131231", "1231231321", "1231231", new Date(), e);
		mb = new ClienteMB();
	}
	
	@Test
	public void insertClient(){
		ClienteRepositorio cr = new ClienteRepositorio();
		cr.persist(c);
		Assert.assertNotNull(cr.load(1L));
		Assert.assertTrue(cr.logar("luan@mail.com.br", "senha"));
		c.setNome("Novo Nome");
		cr.merge(c);
		Assert.assertEquals("Novo Nome", cr.load(1L).getNome());
	}
	
	@Test
	public void testeMB(){
		mb.setEndereco(e);
		mb.setCliente(c);
//		Assert.assertEquals("Luan", mb.actionCadastrarCliente());
	}
	
}
