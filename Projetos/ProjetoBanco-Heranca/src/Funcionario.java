	/* abstract é SEMPRE relacionado com HERANÇA
	 * 
	 * classe abstrata nao tem como ter um objeto ( dar new Funcioanrio() )
	 *
	 * Uma classe abstrata representa um conceito, algo abstrato, 
	 * e o compilador não permite instanciar um objeto dessa classe. 
	 * Para instanciar é preciso criar primeiro uma classe filha não abstrata.
	 */

public abstract class Funcionario { 
	
			
	private String nome;
	private String cpf;
	private double salario; 
	//protected é public apenas para os filhos
	
	/*
	 * abstract no metodo significa que o metodo nao tem corpo
	 * nao tem implementação aqui, apenas nos filhos
	 * dessa forma, tem uma forma padrão de se fazer 
	 * (por isso cada filho tem que ter o seu proprio jeito)
	 * 
	 * Assim que colocamos um método abstrato a classe 
	 * também deve ser abstrata.
	 * Caso a classe seja concreta, ela só pode ter métodos concretos.
	 * metodos concretos = tem impementação
	 * 
	 * Um método abstrato define apenas a assinatura 
	 * (visibilidade, retorno, nome do método e parâmetros).
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
