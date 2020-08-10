
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
		//abaixo é para codigo do getTotal sem o staic 
		//System.out.println("total de contas: " + conta2.getTotal()); 
		//mesmo sendo a conta2, ele imprime 3, porque é um atributo compartilhado
		
		System.out.println("total de contas: " + Conta.getTotal()); 
		
	}
}
