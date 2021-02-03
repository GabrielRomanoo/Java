package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
	
		BigDecimal somaDasMovimentacoes = new MovimentacaoDao().getSomaDasMovimentacoes();
		
		System.out.println("A soma das movimentacoes é: " + somaDasMovimentacoes);
		
	}

}
