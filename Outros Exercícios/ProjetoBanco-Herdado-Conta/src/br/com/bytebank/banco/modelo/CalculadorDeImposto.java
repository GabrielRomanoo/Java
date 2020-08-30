package br.com.bytebank.banco.modelo;

/* br.com.bytebank.banco.modelo.CalculadorDeImposto => FQN
 * 
 * Full Qualified Name é nome completo da classe, 
 * composto pelo nome do pacote e o nome da classe.
 * FQN = Nome Pacote . Nome Simples da Classe
 */

public class CalculadorDeImposto  {
	
	private double totalImposto;
	
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}

}
