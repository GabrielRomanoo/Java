public class Conta {
	// Atributos abaixo (pode ser chamado de campo ou propriedade)
	private double saldo; // N�o � o ideal, tem perda de precisao. existem bibliotecas para guardar saldo
	int agencia; // Os atributos por default tem valores iguais a zero (menos a STRING)
	int numero;
	Cliente titular;	
	
	//m�todos (comportamentos abaixo)
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
		return this.saldo; //nao precisa ter o setSaldo, pois ja temos os metodos saca, deposita e transfere
	}
	
	
	 
}
