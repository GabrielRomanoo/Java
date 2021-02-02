package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TesteRelatorioDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
//		String jpql = "SELECT c FROM Conta c"; // nesta consulta, temos um cenário de n+1 queries para cada conta, pois elas ainda tem as buscas das movimentacoes de cada conta
		String jpql = "SELECT DISTINCT c FROM Conta c left join fetch c.movimentacoes"; //o join fetch faz o hibernate trazer alem das contas, traz todas as movimentacoes da conta de uma vez, sem o n+1 (buscar uma movimentacao de cada vez)
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("---------------------------------");
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Movimentacoes: " + conta.getMovimentacoes());
		}
		System.out.println("---------------------------------");

		em.close();
	}

}
