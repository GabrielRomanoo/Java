
public class ControleBonificacao {
	
	private double soma;
	
	/* mesmo usando uma referencia generica aqui (Funcionario), 
	quando executado, sempre será chamado o método específico do OBJETO 
	ISSO É POLIMORFISMO */
	public void registra(Funcionario f) { 
		double boni = f.getBonificacao();
		this.soma = this.soma + boni;
		
	}
	
	public double getSoma() {
		return soma;
	}

}
