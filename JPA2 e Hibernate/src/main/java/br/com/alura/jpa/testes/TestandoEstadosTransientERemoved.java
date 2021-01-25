package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstadosTransientERemoved {

	public static void main(String[] args) {

		//Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);
		
		// no estado Transient, a conta existe na memoria, mas nao tem vinculo com a jpa
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager(); 
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta);
		
		//Managed -> Removed
		em.remove(conta);
		
		// no estado Removed, ele faz um delete no banco e tira do contexto da jpa
		// A entidade Removed já foi Managed um dia e portanto possui ID. Diferente do Detached, uma entidade Removed não possui registro no banco.
		
		em.getTransaction().commit();
		
	}

}
