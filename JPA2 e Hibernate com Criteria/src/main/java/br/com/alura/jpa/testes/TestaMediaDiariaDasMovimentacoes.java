package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor) from Movimentacao m group by day(m.data), month(m.data), year(m.data)"; //se fosse avg seria uma media
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		List<Double> mediaDasMovimentacoes = query.getResultList();
		
		for (Double media : mediaDasMovimentacoes) {
			System.out.println("A media das movimentacoes é: " + media);
		}
		
		em.close();
	}

}
