package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldoMerge {

	public static void main(String[] args) {
		
		// Transformando o estado detached em managed 
		
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
		// no estado detached, voc� nao consegue fazer a sincroniza��o automatica com o banco. para fazer isso, � preciso transformar o detached em managed, fazendo um merge
		
		EntityManager em2 = emf.createEntityManager();
		
		conta.setSaldo(500.0);
		System.out.println("id -> " + conta.getId());
		// mesmo tendo id, a conta deixou de ser managed para ser detached
		
		em2.getTransaction().begin();
		// mudan�a de estado no banco -> abre transa��o
		
		em2.merge(conta); // transformando a conta detached em managed novamente
		
		em2.getTransaction().commit();
		
		em2.close();
		
		// a query que � disparada para o banco � conseguencia da mudan�a de estados da entidade
		
	}
}
