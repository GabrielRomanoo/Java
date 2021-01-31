package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2L);
		
//		String sql = "select * from movimentacao where conta_id =2";
//		String jpql = "select m from Movimentacao m where m.conta.id =2";
		String jpql = "select m from Movimentacao m where m.conta = :pConta";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = query.getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
		em.close();
	}

}
