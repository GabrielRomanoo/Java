
public class TesteReferencias {

	public static void main(String[] args) {
		
		Funcionario g1 =  new Gerente();
		//f.autentica(1234);
		/*
		 * o codigo nao compilou porque quem define o que 
		 * podemos chamar é a referência, que é do tipo Funcionario, 
		 * e a classe Funcionario realmente não tem esse método.
		 */
		//Funcionario g1 =  new Gerente(); 
		//Funcionario é referencia mais generica, porque gerente é um funcionario. ISSO É POLIMORFISMO
		
		g1.setNome("marcos");
		g1.setSalario(5000.0);
		
		//Funcionario f = new Funcionario(); //nao pode mais criar porque funcionario é abstract
		
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
