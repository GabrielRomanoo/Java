package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
//		MovimentacaoDao dao = new MovimentacaoDao(em);
//		List<Movimentacao> movimentacaoesFiltradasPorData = dao.getMovimentacoesFiltradasPorData(31, 01, 2021);
//		for (Movimentacao movimentacao : movimentacaoesFiltradasPorData) {
//			System.out.println("Descricao -> " + movimentacao.getDescricao());
//			System.out.println("Valor -> " + movimentacao.getValor());
//			System.out.println("------------------------------------");
//		}
		TypedQuery<Movimentacao> query = em.createQuery("SELECT c FROM Movimentacao c", Movimentacao.class);
		List<Movimentacao> results = query.getResultList();
		 
		for (Movimentacao movimentacao2 : results) {
			
			System.out.println("Descricao -> " + movimentacao2.getDescricao());
			System.out.println("Valor -> " + movimentacao2.getValor());
			System.out.println("------------------------------------");
		}
		
		

		
	}

}
