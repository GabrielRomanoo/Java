package br.com.alura;

import java.util.TreeSet;

public class TestaRecibo {

	public static void main(String[] args) {

		Recibo rec1 = new Recibo();
		// atribui valores
		Recibo rec2 = new Recibo();
		// atribui valores
		Recibo rec3 = new Recibo();
		// atribui valores

		TreeSet<Recibo> recibos = new TreeSet<>();
		recibos.add(rec1);

		/*
		 * 
		 * Para adicionarmos um objeto em um TreeSet ele precisa implementar a interface
		 * Comparable. Mas o que fazer se estamos trabalhando com uma instância de uma
		 * classe que não temos acesso ou não podemos modificar para implementar
		 * Comparable? Nesse caso, o construtor do TreeSet recebe como parâmetro um
		 * objeto que implementa Comparator. Dessa forma, o critério de comparação pode
		 * ser criado em separado da classe na qual opera.
		 */
		

	}
}
