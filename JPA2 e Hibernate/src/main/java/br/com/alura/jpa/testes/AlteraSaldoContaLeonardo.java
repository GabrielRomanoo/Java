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
		
		//contaDoLeonardo se encontra no estado managed, porque a jpa tem uma referencia dela no banco. por conta disso, quando fazemos uma alteração, nao precisamos informar para a jpa que houve essa alteração, porque ela ja tem uma referencia da conta e automaticamente sabe que teve uma alteração
		//em um estado managed, quando dado o commit, a jpa verifica atributo por atributo para ver se teve alteração
		
		em.getTransaction().begin();
		
		contaDoLeonardo.setSaldo(20.0); //o hibernate atualizou o saldo do leonardo no banco de dados por debaixo dos panos
		
		em.getTransaction().commit();
		
		//o estado managed é alcançado quando damos um find, ou um persist

	}

}
