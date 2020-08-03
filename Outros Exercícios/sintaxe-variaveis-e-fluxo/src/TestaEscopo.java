
public class TestaEscopo {

	public static void main(String[] args) {
		System.out.println("testando condicionais");
		
		int idade = 18;
		int quantidadePessoas = 3;		
		
		//boolean acompanhado = quantidadePessoas >= 2; //a expressao 'quantidadePessoas >= 2' retorna true ou false
		
		boolean acompanhado; //é uma variavel temporária/local, entao nao tem valor deafult
		
		if (quantidadePessoas >= 2) {
			acompanhado = true;
		} else {
			acompanhado = false;
		}
		
		
		System.out.println("valor de acompanhado = " + acompanhado);
		if (idade >= 18 && acompanhado) { 
			System.out.println("seja bem vindo");
			
		} else {
			System.out.println("infelizmente você não pode entrar");
		}	
	}

}
