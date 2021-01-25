package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //fabrica de entity manager
		EntityManager em = emf.createEntityManager(); //criando entity manager
		
		Conta contaDoLeonardo = em.find(Conta.class, 1L); //1L seria o id do registro que quero pegar
		
		em.getTransaction().begin();
		
		contaDoLeonardo.setSaldo(20.0); //o hibernate atualizou o saldo do leonardo no banco de dados por debaixo dos panos
		
		em.getTransaction().commit();

	}

}
