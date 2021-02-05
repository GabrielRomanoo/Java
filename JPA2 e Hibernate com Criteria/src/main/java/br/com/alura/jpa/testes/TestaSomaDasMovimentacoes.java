package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //podeira tirar este codigo e encapsular em outro lugar
		EntityManager em = emf.createEntityManager(); 
	
		/* USANDO JPQL
		BigDecimal somaDasMovimentacoes = new MovimentacaoDao(em).getSomaDasMovimentacoes();
		
		System.out.println("A soma das movimentacoes é: " + somaDasMovimentacoes); */
		
		/* USANDO CRITERIA */
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		// select m from Movimentacao m
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		//sum(m.valor)
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		// select sum(m.valor) from Movimentacao m
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println("A soma das movimentacoes é: " +typedQuery.getSingleResult());
	}

}
