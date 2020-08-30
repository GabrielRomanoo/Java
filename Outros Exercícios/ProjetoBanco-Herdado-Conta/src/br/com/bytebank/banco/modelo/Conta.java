package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta.
 * 
 * @author Gabriel Romano
 *
 */

public abstract class Conta {
	
	protected double saldo; 
	private int agencia;
	private int numero;
	private Cliente titular;	
	private static int total; 
	
	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e numero.
	 * 
	 * @param agencia
	 * @param numero
	 */
	
	public Conta(int agencia, int numero) {
		Conta.total++; //atributo de classe
		//System.out.println("o total de contas é: " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		//System.out.println("estou criando uma conta " + this.numero);
		
	}
	
	public abstract void deposita(double valor); ;//obriga filhos a implementar
	
	/**
	 * Valor precisa ser maior do que o saldo.
	 * 
	 * @param valor
	 * @throws SaldoException
	 */
	
	public void saca(double valor) throws SaldoException{
		if(this.saldo < valor) {
			throw new SaldoException("Valor invalido: Saldo: " + this.saldo + ", Valor: " + valor);
		} 
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoException{
		this.saca(valor);   //vai chamar o metodo saca específico da classe que foi invocada
		//o this acima aponta para o objeto que a chamou
		destino.deposita(valor); //so vai chegar nessa linha se der bom no saca
			
	}
	
	public double getSaldo( ) {
		return this.saldo; 
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("nao pode valor <= 0");
			return; 
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
		return Conta.total;
	}
	
	@Override
	public String toString() {
		
		return "Numero: " + this.numero + ", Agencia: " + this.agencia;
	}
	
	
	
	 
}
