import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
 * ANOTAÇÕES
 * 
 * Lambdas: equivalentes as interfaces funcionais.
 * 
 * Uma interface que possui apenas um método abstrato é conhecida como interface funcional.
 * 
 *  
 */

public class OrdenaStringsComLambda {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online"); // poderia usar o Arrays.asList()
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Collections.sort(palavras); 
		
	/*	palavras.sort((s1, s2)-> {
				if (s1.length() < s2.length()) {
					return -1;
				}
				if (s1.length() > s2.length()) {
					return 1;
				}
				return 0;
			}); */
		
		/* OU */
		
		palavras.sort((s1, s2)-> s1.length() - s2.length());
		
		/* OU */
		
		palavras.sort((s1, s2)-> Integer.compare(s1.length(), s2.length()));
	

		/* FORMA JAVA 8 ABAIXO (LAMBDAS) */

	    palavras.forEach((String s) -> { //lambda
			System.out.println(s);
		}); 
		
		/* OU */
		
	    palavras.forEach(s -> { //lambda
			System.out.println(s);
		}); 
		
		/* OU */
		
		palavras.forEach(s -> System.out.println(s)); // lambda
		
		/* OU */
		
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
	
		/* EXEMPLO COM THREAD */
		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
		/*
		 * os parâmetros passados, seguindo a sintaxe do lambda, serão os parâmetros 
		 * que o método abstrato da interface funcional receberia - ou seja, como o 
		 * método run() da interface Runnable não recebe nenhum argumento, 
		 * o parâmetro (i.e. o que vem antes da seta) é passado como vazio
		 */
		
		new Thread(() ->
		        System.out.println("Executando um Runnable")
		    ).start();
		
		/*
		 * Sendo mais sucinto, parece-me que na expressão lambda os parâmetros 
		 * passados não têm ligação direta com o método que a usa como argumento, 
		 * mas estará diretamente ligado ao método abstrato da interface funcional. 
		 * A única ligação da expressão lambda com o método que a utiliza é 
		 * na verdade em relação ao tipo.
		 */
	}
}