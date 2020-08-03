
public class TesteReferencias {
	
	public static void main(String[] args) {
		Conta primeiraConta = new Conta(); //se tem new, foi criado um objeto
		primeiraConta.saldo = 300;
		/* 
		* Na verdade a variavel primeiraConta não é um objeto tipo Conta, 
		* e sim uma referencia (flecha) a um objeto.
		*/
		
		System.out.println("saldo da primeira: " + primeiraConta.saldo);
		
		Conta segundaConta = primeiraConta; //nao tem new, entao nao foi criado um novo objeto
		 /*
		 * Duas referências para o mesmo objeto.
		 * O '=' no java copia e cola, no entanto, 
		 * ele copia e cola o endereço de memória.
		 */
		
		System.out.println("saldo da segunda conta: " + segundaConta.saldo);
		
		segundaConta.saldo += 100;
		System.out.println("saldo da segunda conta: " + segundaConta.saldo);
		
		System.out.println("saldo da primeira: " + primeiraConta.saldo);
		/* 
		 * vai sair 400 acima porque temos apenas uma conta (um objeto) criado
		 * primeiraConta e segundaConta são duas referencias pro mesmo objeto
		 */
		
		if (primeiraConta == segundaConta) {
			System.out.println("sao a mesmissima conta");
		}
		
		
		
		
	}

}
