package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	

	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
//		String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);

		// a jpql nos permite instanciar objetos direto na query
		// para cada resultado da query, é instanciado um objetio MediaComData

		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "SELECT sum(m.valor) from Movimentacao m"; // se fosse avg seria uma media
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);

		return query.getSingleResult();
	}

}
