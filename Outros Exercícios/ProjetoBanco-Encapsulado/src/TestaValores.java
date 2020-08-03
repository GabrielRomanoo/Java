
public class TestaValores {

	public static void main(String[] args) {
		//usando os codigos abaixo, 
		//conta está inconsistente perante a regra de negocio, tem que usar o construtor
		//conta.setAgencia(-50);
		//conta.setNumero(-330);
		
		Conta conta = new Conta(1337, 24226);
		Conta conta2 = new Conta(1337, 16549);
		Conta conta3 = new Conta(1337, 14660);
		
				
		//System.out.println(Conta.total); //se nao fosse privado
		System.out.println(conta2.getTotal());
	}
}
