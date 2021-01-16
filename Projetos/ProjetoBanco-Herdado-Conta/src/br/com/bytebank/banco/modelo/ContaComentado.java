package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Gabriel Romano
 *
 */

public abstract class ContaComentado {
	
	// Atributos abaixo (pode ser chamado de campo ou propriedade)
	protected double saldo; // usar double no salario não é o ideal, tem perda de precisao. existem bibliotecas para guardar saldo
	private int agencia; // Os atributos por default tem valores iguais a zero (menos a STRING)
	private int numero;
	private Cliente titular;	
	private static int total; 
	// precisa do static para que essa variavel seja igual para todos os objetos
	// quando tem static, vira um atributo compartilhado da classe Conta, e nao de cada objeto
	// quando tem static, o atributo é DA CLASSE
	
	// construtor (nao é um metodo, é uma rotina de inicialização 
	// NAO HERDA O CONSTRUTOR NAS FILHAS) 
	public ContaComentado(int agencia, int numero) {
		// populando os atributos aqui embaixo
		ContaComentado.total++; //atributo de classe
		//System.out.println("o total de contas é: " + Conta.total);
		this.agencia = agencia; //atributo de instancia(objeto)
		this.numero = numero;
		//System.out.println("estou criando uma conta " + this.numero);
		
	}
	
	//métodos (comportamentos abaixo)
	public abstract void deposita(double valor); ;//obriga filhos a implementar
	
	public void saca(double valor) throws SaldoException{
		if(this.saldo < valor) {
			//problema
			throw new SaldoException("Valor invalido: Saldo: " + this.saldo + ", Valor: " + valor);
		} 
		this.saldo -= valor;
	}
	
	public void transfere(double valor, ContaComentado destino) throws SaldoException{
		this.saca(valor);   //vai chamar o metodo saca específico da classe que foi invocada
		//o this acima aponta para o objeto que a chamou
		destino.deposita(valor); //so vai chegar nessa linha se der bom no saca
		//se der ruim no saca, não é transfere que vai tratar a exceção, 
		//pois ja vai ter saido desse metodo, mudado o fluxo da pilha
			
	}
	
	// nao precisa ter o setSaldo, pois ja temos os metodos saca, deposita e transfere
	public double getSaldo( ) {
		return this.saldo; 
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	// normalmente metodos que alteram atributo sao void
	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("nao pode valor <= 0");
			return; //para a execução
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("nao pode valor menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	/*
	public int getTotal() {
		return Conta.total;
	}
	*/
	
	//abaixo nao é um metodo da instancia (objeto), e sim um metodo da CLASSE
	public static int getTotal() {
		return ContaComentado.total;
	}
	
	
	
	 
}
