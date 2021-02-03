package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoesComDataProjecao {

	public static void main(String[] args) {
		
		//INJEÇÃO DE DEPENDENCIAS
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura"); //podeira tirar este codigo e encapsular em outro lugar
		EntityManager em = emf.createEntityManager(); 

		List<MediaComData> movimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();

		for (MediaComData resultado : movimentacoes) {
			System.out.println("A media das movimentacoes do dia " + resultado.getDia() + "/" + resultado.getMes()
					+ " é: " + resultado.getValor());
		}

	}

}
