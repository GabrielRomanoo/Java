package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta {
	/*
	 * CONSTRUTORES NAO SAO HERDADOS
	 * 
	 * A partir do momento em que voc� escreve um construtor na 
	 * classe m�e o construtor padr�o (default) deixa de existir.
	 * 
	 * Logo, quando voc� escreve a classe filha sem um construtor, 
	 * o construtor padr�o � chamado implicitamente por debaixo dos panos.
	 * 
	 * E temos que ter um construtor na classe filha que realmente invoque 
	 * algum construtor existente na classe m�e.
	 * 
	 * Se na classe m�e, nao tiver nenhum construtor default, ser� preciso 
	 * invocar um construtor espec�fico da classe mae pela classe filha.
	 */
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
	
	@Override
	public String toString() {
		return "ContaPoupanca, " + super.toString();
	}
}
