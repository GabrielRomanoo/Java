
public class Gerente extends Funcionario implements Autenticavel { 
	//Gerente � um Funcionario, Gerente herda da classe Funcionario, assina o contrato Autenticavel, � um Autenticavel
		
	private AutenticacaoUtil autenticador; 
	// ISSO � COMPOSI��O
	//forma de reutilizacao de codigo sem heran�a (composi��o)
	//o ciclo de vida de dos objetos de Gerente e AutenticacaoUtil est�o ligados
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
		//super indica que o atributo/m�todo � da classe de cima, do pai/mae
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