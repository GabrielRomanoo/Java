
public class TesteContaSemCliente {

	public static void main(String[] args) {
		Conta contaDaMarcela = new Conta();
		System.out.println(contaDaMarcela.getSaldo());
		
		contaDaMarcela.titular = new Cliente(); 
		/*
		 * a express�o acima subsitui a seguinte express�o:
		 * 
		 * Cliente marcela = new Cliente();
		 * contaDaMarcela.titular = marcela; 
		 */
		
		/* null siguinifica que aquela referencia nunca foi populada */
		
		/* n�o existe objeto dentro de objeto/variavel, 
		 * � sempre tudo feito atraves de referencias */
		
		System.out.println(contaDaMarcela.titular);
		contaDaMarcela.titular.nome = "marcela";
		System.out.println(contaDaMarcela.titular.nome);

	}

}
