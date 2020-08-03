public class Conta {
	// Atributos abaixo (pode ser chamado de campo ou propriedade)
	private double saldo; // Não é o ideal, tem perda de precisao. existem bibliotecas para guardar saldo
	private int agencia; // Os atributos por default tem valores iguais a zero (menos a STRING)
	private int numero;
	private Cliente titular;	
	private static int total; //precisa do static para que essa variavel seja igual para todos os objetos
	//quando tem static, vira um atributo compartilhado da classe Conta, e nao de cada objeto
	//quando tem static, o atributo é DA CLASSE
	
	//construtor (nao é um metodo, é uma rotina de inicialização) 
	public Conta(int agencia, int numero) {
		//populando os atributos aqui embaixo
		Conta.total++; //atributo de classe
		//System.out.println("o total de contas é: " + Conta.total);
		this.agencia = agencia; //atributo de instancia(objeto)
		this.numero = numero;
		//System.out.println("estou criando uma conta" + this.numero);
		
	}
	
	//métodos (comportamentos abaixo)
	public void deposita(double valor) { //void retorna nada
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public boolean transfere(double valor, Conta destino) {
		if(this.saldo >= valor) {
			//this.saldo -= valor;
			this.saca(valor);
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	
	public double getSaldo( ) {
		return this.saldo; // nao precisa ter o setSaldo, pois ja temos os metodos saca, deposita e transfere
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) { // normalmente metodos que alteram atributo sao void
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
	
	public int getTotal() {
		return Conta.total;
	}
	
	
	 
}
