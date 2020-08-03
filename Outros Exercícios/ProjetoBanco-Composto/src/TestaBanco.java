
public class TestaBanco {
	
	public static void main(String[] args) {
		Cliente gabriel = new Cliente();
		// vamos "popular" abaixo
		gabriel.nome = "gabriel romano";
		gabriel.cpf = "222.222.222-22";
		gabriel.profissao = "programador";
		
		Conta contaDoGabriel = new Conta();
		contaDoGabriel.deposita(100);
		
		//associa o cliente gabriel a conta contaDoGabriel
		contaDoGabriel.titular = gabriel;
		
		System.out.println(contaDoGabriel.titular.nome);
		System.out.println(contaDoGabriel.titular);
		System.out.println(gabriel);
		
	}

}
