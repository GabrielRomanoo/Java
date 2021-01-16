	/* abstract � SEMPRE relacionado com HERAN�A
	 * 
	 * classe abstrata nao tem como ter um objeto ( dar new Funcioanrio() )
	 *
	 * Uma classe abstrata representa um conceito, algo abstrato, 
	 * e o compilador n�o permite instanciar um objeto dessa classe. 
	 * Para instanciar � preciso criar primeiro uma classe filha n�o abstrata.
	 */

public abstract class Funcionario { 
	
			
	private String nome;
	private String cpf;
	private double salario; 
	//protected � public apenas para os filhos
	
	/*
	 * abstract no metodo significa que o metodo nao tem corpo
	 * nao tem implementa��o aqui, apenas nos filhos
	 * dessa forma, tem uma forma padr�o de se fazer 
	 * (por isso cada filho tem que ter o seu proprio jeito)
	 * 
	 * Assim que colocamos um m�todo abstrato a classe 
	 * tamb�m deve ser abstrata.
	 * Caso a classe seja concreta, ela s� pode ter m�todos concretos.
	 * metodos concretos = tem impementa��o
	 * 
	 * Um m�todo abstrato define apenas a assinatura 
	 * (visibilidade, retorno, nome do m�todo e par�metros).
	 */
	public abstract double getBonificacao(); 
	
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
