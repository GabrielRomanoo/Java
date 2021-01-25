package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldoEstadoManaged {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //fabrica de entity manager
		EntityManager em = emf.createEntityManager(); //criando entity manager
		
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);
		
		//na jpa, nao vem por padrao o autocommit, como no jdbc
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		//conta esta em estado managed, e a jpa setou automaticamente o id. CUIDADO: nem toda conta com id é necessariamente managed
		
		conta.setSaldo(1000.0);
		
		em.getTransaction().commit();
		
		// a entidade no estado managed está automaticamente sincronizada com o banco
		
	}

}
