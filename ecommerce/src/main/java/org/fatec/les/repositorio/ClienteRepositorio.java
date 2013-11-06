package org.fatec.les.repositorio;

import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.utils.Criptografia;

public class ClienteRepositorio extends BaseRepositorio<ClienteEntity>{
	
	public boolean logar(String email, String senha){
		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);
		
		//String sql = "Select cliente from Cliente where email = " + email + " and senha = " + senha;  
		String sql = "Select from ClienteEntity Cliente where email = ?1 and senha = ?2 ";
		
		ClienteEntity cliente = (ClienteEntity) entityManager.createQuery(sql).setParameter(1, email).setParameter(2, senha).getSingleResult();
		if (cliente!= null){
			return true;
		}
		return false;
		
	}
	
	
}
