package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMediaDiariaDasMovimentacoesComData {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)"; //se fosse avg seria uma media
		Query query = em.createQuery(jpql);
		
		List<Object[]> movimentacoes = query.getResultList();
		
		for (Object[] obj : movimentacoes) {
			System.out.println("A media das movimentacoes do dia " + obj[1] + "/" + obj[2] + " é: " + obj[0]);
		}
		
		em.close();
	}

}
