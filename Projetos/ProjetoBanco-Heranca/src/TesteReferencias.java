
public class TesteReferencias {

	public static void main(String[] args) {
		
		Funcionario g1 =  new Gerente();
		//f.autentica(1234);
		/*
		 * o codigo nao compilou porque quem define o que 
		 * podemos chamar � a refer�ncia, que � do tipo Funcionario, 
		 * e a classe Funcionario realmente n�o tem esse m�todo.
		 */
		//Funcionario g1 =  new Gerente(); 
		//Funcionario � referencia mais generica, porque gerente � um funcionario. ISSO � POLIMORFISMO
		
		g1.setNome("marcos");
		g1.setSalario(5000.0);
		
		//Funcionario f = new Funcionario(); //nao pode mais criar porque funcionario � abstract
		
		Funcionario d = new EditorVideo();
		d.setSalario(2000.0);
		
		Funcionario ev = new Designer();
		ev.setSalario(2500.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g1);
		controle.registra(ev);
		controle.registra(d);
		
		
		System.out.println(controle.getSoma());
		

	}

}
