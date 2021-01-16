
public class CriarConta {
	
	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta(); //instanciando um objeto ('new')
		primeiraConta.saldo = 200; 
		System.out.println(primeiraConta.saldo);
		/*na verdade a variavel primeiraConta não é um objeto tipo Conta, 
		e sim uma referencia (flecha) a um objeto*/
		primeiraConta.saldo += 100;
		primeiraConta.agencia = 146;
		
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 300;
		
		System.out.println("primeira conta tem: " + primeiraConta.saldo);
		System.out.println("segunda conta tem: " + segundaConta.saldo);
		
		System.out.println(primeiraConta.agencia);
		System.out.println(primeiraConta.numero);
		
		System.out.println(segundaConta.agencia);
		
		segundaConta.agencia = 146;
		
		System.out.println("agora o novo valor vale: " + segundaConta.agencia);
		
		if (primeiraConta == segundaConta) {
			System.out.println("sao a mesmissima conta");
		} else {
			System.out.println("contas diferentes");
		}
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
		
		
		
	}

}
