package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TestaMediaDiariaDasMovimentacoesComDataTipada {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		
		//a jpql nos permite instanciar objetos direto na query
		//para cada resultado da query, é instanciado um objetio MediaComData

		List<MediaComData> movimentacoes = query.getResultList();

		for (MediaComData resultado : movimentacoes) {
			System.out.println("A media das movimentacoes do dia " + resultado.getDia() + "/" + resultado.getMes()
					+ " é: " + resultado.getValor());
		}

		em.close();
	}

}
