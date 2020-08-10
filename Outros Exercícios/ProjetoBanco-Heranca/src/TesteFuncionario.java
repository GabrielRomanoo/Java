
public class TesteFuncionario {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
				
		//Funcionario nico = new Gerente();
		Gerente nico = new Gerente();
		nico.setNome("nico steepat");
		nico.setCpf("234323112-2");
		nico.setSalario(2600.00);
		
		System.out.println(nico.getNome());
		System.out.println(nico.getBonificacao());
				
		//nico.salario = 300;
				
	}

}
