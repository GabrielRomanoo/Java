public class Conta {
	// Atributos abaixo (pode ser chamado de campo ou propriedade)
	double saldo; // Não é o ideal, tem perda de precisao. existem bibliotecas para guardar saldo
	int agencia; // Os atributos por default tem valores iguais a zero (menos a STRING)
	int numero;
	String titular;
	String cpf;
	String profissao;
	
	
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
	 
}
