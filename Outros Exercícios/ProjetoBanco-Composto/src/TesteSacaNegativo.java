
public class TesteSacaNegativo {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.deposita(100);
		System.out.println(conta.saca(101));
		
		/* 
		 * abaixo é proibido nunca devemos mexer nos atributos, e sim invocar metodos
		 * por isso, botei como private, encapsulei o atributo
		 */
		//conta.saldo = conta.saldo - 101;
		
		System.out.println(conta.getSaldo());

	}

}
