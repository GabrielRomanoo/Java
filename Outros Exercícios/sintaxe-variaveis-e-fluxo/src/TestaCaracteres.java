
public class TestaCaracteres {

	public static void main(String[] args) {
		
		char letra = 'a'; //tabela unicode
		System.out.println(letra);
		
		char valor = 66;
		System.out.println(valor);
		
		valor = (char) (valor + 1); //um int nao cabe num char, mas um char cabe num int
		System.out.println(valor);
		
		String palavra = "gabriel romano";
		System.out.println(palavra);
		
		palavra = palavra + 2020;
		System.out.println(palavra);
		
	}

}
