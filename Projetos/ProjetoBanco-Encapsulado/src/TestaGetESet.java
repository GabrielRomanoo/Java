
public class TestaGetESet {
	
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 24226);
		//conta.numero = 1337;
		//conta.setNumero(1337); ja foi setado no construtor
		System.out.println(conta.getNumero());
		
		Cliente gabriel = new Cliente();
		gabriel.setNome("gabriel romano");

		//conta.titular = gabriel; jeito sem encapsulamento (private)
		conta.setTitular(gabriel);
		
		
		System.out.println(conta.getTitular().getNome()); //getTitular é uma referencia pro cliente gabriel
		
		conta.getTitular().setProfissao("programador");
		//conta.getTitular() é a mesma coisa que Cliente gabirel
		
		Cliente titularDaConta = conta.getTitular(); //Cliente titularDaConta == Cliente gabriel
		titularDaConta.setProfissao("programador");
		
		System.out.println(titularDaConta);
		System.out.println(gabriel);
		System.out.println(conta.getTitular());
	}

}
