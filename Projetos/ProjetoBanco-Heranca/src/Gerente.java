
public class Gerente extends Funcionario implements Autenticavel { 
	//Gerente é um Funcionario, Gerente herda da classe Funcionario, assina o contrato Autenticavel, é um Autenticavel
		
	private AutenticacaoUtil autenticador; 
	// ISSO É COMPOSIÇÃO
	//forma de reutilizacao de codigo sem herança (composição)
	//o ciclo de vida de dos objetos de Gerente e AutenticacaoUtil estão ligados
	//quando um nasce, o outro nasce
	//quando um morre, o outro morre
	//um depende do outro
	
	public Gerente() {
		this.autenticador = new AutenticacaoUtil(); 
	}
	
    public double getBonificacao() {
    	System.out.println("chamando o metodo de bonificacao do Gerente");
    	return super.getSalario(); 
		//return super.getBonificacao() + super.getSalario(); 
		//super indica que o atributo/método é da classe de cima, do pai/mae
	}

    @Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
	
	
}