package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //fabrica de entity manager
		EntityManager em = emf.createEntityManager(); //criando entity manager
		
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1235);
		conta.setAgencia(4321);
		
		//na jpa, nao vem por padrao o autocommit, como no jdbc
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		
	}

}
