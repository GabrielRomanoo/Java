package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT sum(m.valor) from Movimentacao m"; //se fosse avg seria uma media
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("A soma das movimentacoes é: " + somaDasMovimentacoes);
		em.close();
	}

}
