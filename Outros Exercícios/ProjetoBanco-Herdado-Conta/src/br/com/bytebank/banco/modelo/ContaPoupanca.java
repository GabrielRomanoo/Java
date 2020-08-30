package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta {
	/*
	 * CONSTRUTORES NAO SAO HERDADOS
	 * 
	 * A partir do momento em que você escreve um construtor na 
	 * classe mãe o construtor padrão (default) deixa de existir.
	 * 
	 * Logo, quando você escreve a classe filha sem um construtor, 
	 * o construtor padrão é chamado implicitamente por debaixo dos panos.
	 * 
	 * E temos que ter um construtor na classe filha que realmente invoque 
	 * algum construtor existente na classe mãe.
	 * 
	 * Se na classe mãe, nao tiver nenhum construtor default, será preciso 
	 * invocar um construtor específico da classe mae pela classe filha.
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
