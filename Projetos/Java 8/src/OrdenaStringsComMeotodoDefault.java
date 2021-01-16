import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
 * ANOTAÇÕES
 * 
 * Metodos defaults: 
 * A grande vantagem é que agora uma interface pode evoluir sem quebrar compatibilidade.
 * Basicamente nas interfaces você pode declarar um método 'default', e com isso todas as classes filhas irão herdá-lo com a mesma implementação.
 * 
 *  
 */

public class OrdenaStringsComMeotodoDefault {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online"); // poderia usar o Arrays.asList()
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Collections.sort(palavras); //usa o critério de comparação default da classe String
//		System.out.println(palavras);
		
		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparador);
		palavras.sort(comparador); // forma java 8, utiliza metodos defaults (o sort é o metodo default)
		System.out.println(palavras);
		
//		for (String string : palavras) {
//			System.out.println(string);
//		}
		
//		Consumer<String> consumidor = new ImprimeNaLinha();
//		palavras.forEach(consumidor);
		
		Consumer<String> consumidor = new Consumer<String>() {//classe anonima, dando new numa interface
			@Override
			public void accept(String s) {
				System.out.println(s);
			} 
		};

	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}
}
