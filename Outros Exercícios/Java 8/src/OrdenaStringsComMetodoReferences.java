import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * ANOTAÇÕES
 * 
 * Um lambda faz o seguinte: dado um objeto, invoca um metodo num objeto
 * 
 * É muito comum escrevermos lambdas curtos, que simplesmente invocam um único método. 
 * É o exemplo de s -> s.length(). Dada uma String, invoque e retorne o método length. 
 * Por esse motivo, há uma forma de escrever esse tipo de lambda de uma forma ainda mais reduzida
 * 
 * String:: length == s -> s.length().
 * 
 * 
 *  
 */

public class OrdenaStringsComMetodoReferences {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online"); // poderia usar o Arrays.asList()
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		Collections.sort(palavras);

		//FORMA COMPLETA
//		palavras.sort((s1, s2) -> { //lambda com muita lógica não é o ideal
//			if (s1.length() < s2.length()) {
//				return -1;
//			}
//			if (s1.length() > s2.length()) {
//				return 1;
//			}
//			return 0;
//		});

		//FORMA IDEAL
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//FORMA IDEAL SIMPLIFICADA
		palavras.sort(Comparator.comparing(s -> s.length())); //ver anotações
		palavras.sort(Comparator.comparing(String::length)); // Metodo reference, é uma sintaxe clara para dizer que queremos invocar um metodo simples
		
		
		
		//VARIACAO FORMA IDEAL SIMPLIFICADA
		Function<String, Integer> funcao = s -> s.length(); // interface function, dada uma String, retorna um Integer
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		//VARIACAO FUNCTION (sem lambda)
		Function<String, Integer> funcao2 = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Function<String, Integer> funcao3 = String::length; //metodo reference
		
		System.out.println(palavras);

//		Consumer<String> impressor = s -> System.out.println(s);
		Consumer<String> impressor = System.out::println; //metodo reference
		palavras.forEach(impressor);
		
			
//		palavras.forEach(s -> System.out.println(s)); // lambda
		palavras.forEach(System.out::println); // metodo reference
		
//		-----------------------------------------------------------
//		EXERCICIO
//		Mude o seu comparator usando algum outro critério de comparação 
//		no lugar do tamanho(length) da String.
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(palavras);
		


	}
}