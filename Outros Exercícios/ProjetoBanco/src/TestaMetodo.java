
public class TestaMetodo {
	
	public static void main(String[] args) {
		Conta contaDoGabriel = new Conta();
		contaDoGabriel.saldo = 100;
		contaDoGabriel.deposita(50);
		System.out.println(contaDoGabriel.saldo);
		
		boolean conseguiuRetirar = contaDoGabriel.saca(20);
		System.out.println(contaDoGabriel.saldo);
		System.out.println(conseguiuRetirar);
		
		Conta contaDaMarcela = new Conta();
		contaDaMarcela.deposita(1000);
		
		boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoGabriel);
		
		if(sucessoTransferencia) {
			System.out.println("transferencia feita com sucesso");
		} else {
			System.out.println("faltou dinheiro");
		}
		
		System.out.println(contaDaMarcela.saldo);
		System.out.println(contaDoGabriel.saldo);
		
		contaDoGabriel.titular = "gabriel romano";
		
		System.out.println(contaDoGabriel.titular);
		
		
	}
}
