package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldoEstadoDetached {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //fabrica de entity manager
		EntityManager em = emf.createEntityManager(); //criando entity manager
		
		Conta conta = new Conta();
		conta.setTitular("Reinaldo");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		// agora a conta virou para estado detached, pois o entity manager foi fechado
		// no estado detached, você nao consegue fazer a sincronização automatica com o banco. para fazer isso, é preciso transformar o detached em managed, fazendo um merge
		
		conta.setSaldo(500.0);
		System.out.println("id -> " + conta.getId());
		
		// mesmo tendo id, a conta deixou de ser managed para ser detached
		
	}

}
