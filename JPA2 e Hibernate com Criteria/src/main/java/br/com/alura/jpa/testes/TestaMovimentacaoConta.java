package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		//buscar a primeira movimentacao 
		Movimentacao movimentacao = em.find(Movimentacao.class, 3L); //o metodo find devolve uma entidade no estado maneged
		Conta conta = movimentacao.getConta();
		
		//buscar a quantidade de movimentacoes da conta
		int quantidadeDeMovimentacoes = conta.getMovimentacoes().size();
		
		System.out.println("qtde movimentacoes: " + quantidadeDeMovimentacoes);
		System.out.println("titular da conta: " + conta.getTitular());
		em.close();
	}

}
