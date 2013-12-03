package org.fatec.les.repositorio;

import javax.persistence.NoResultException;

import org.fatec.les.model.entity.ClienteEntity;
import org.fatec.les.model.utils.Criptografia;

public class ClienteRepositorio extends BaseRepositorio<ClienteEntity> {

	public boolean logar(ClienteEntity cliente) {

		String email = cliente.getEmail();
		String senha = cliente.getSenha();

		senha = Criptografia.criptografar(senha);

		String sql = "Select c from ClienteEntity c where email = ?1 and senha = ?2 ";

		ClienteEntity retorno = (ClienteEntity) entityManager.createQuery(sql)
				.setParameter(1, email).setParameter(2, senha)
				.getSingleResult();
		if (retorno != null) {
			return true;
		}
		return false;

	}

	public boolean logar(String email, String senha){
		
	
		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);
		
		String sql = "Select c from ClienteEntity c where email = ?1 and senha = ?2 ";

		try {
			entityManager.createQuery(sql).setParameter(1, email).setParameter(2, senha).getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}

	public ClienteEntity getClienteByEmail(String email) {
		String sql = "Select c from ClienteEntity c where email = ?1";
		ClienteEntity cliente = (ClienteEntity) entityManager.createQuery(sql)
				.setParameter(1, email).getSingleResult();
		return cliente;
	}

}
