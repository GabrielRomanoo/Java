package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

/* 
 * ANOTA��ES
 * -----------------------------------------------------------------------
 * AULA 01
 * 
 * System.out.println(aulas); // toString
 * Qual � o resultado desse c�digo? Ele mostra as aulas adicionadas em sequ�ncia! 
 * Por que isso acontece? Pois a classe ArrayList, ou uma de suas m�es, 
 * reescreveu o m�todo toString, para que internamente fizesse um for, 
 * concatenando os seus elementos internos separados por v�rgula.
 * 
 * aulas.remove(0);
 * Por que 0? Pois as listas, assim como a maioria dos casos no Java, 
 * s�o indexadas a partir do 0, e n�o do 1.
 * 
 * for (String aula : aulas) {...
 * O for de uma maneira especial, chamada de enhanced for, 
 * ou popularmente foreach. Lembrando que foreach n�o existe 
 * no Java como comando, e sim como um caso especial do for mesmo.
 * 
 * aulas.forEach(aula -> {...});
 * Uma outra forma de percorrer nossa lista � utilizando as sintaxes e 
 * m�todos novos inclu�dos no Java 8. Temos um m�todo (n�o um comando!) 
 * agora que se chama forEach. Ele recebe um objeto do tipo Consumer, 
 * mas o interessante � que voc� n�o precisa cri�-lo, voc� pode utilizar 
 * uma sintaxe bem mais enxuta, mas talvez assustadora a primeira vista, 
 * chamada lambda (-> { }).
 * 
 * -----------------------------------------------------------------------
 */

public class TestandoListas {

	public static void main(String[] args) {

		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe aula";
		String aula3 = "Trabalhando com Crusos e Sets";

		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		System.out.println(aulas); // toString

		aulas.remove(0);
		System.out.println(aulas);

		// foreach/enhanced for (n�o � comando, serve apenas para o eclipse)
		for (String aula : aulas) { // para cada aula dentro de aulas
			System.out.println("Aula: " + aula);
		}

		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula � " + primeiraAula);

		// "substitui o enhanced for, mas n�o � eficiente
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("aula: " + aulas.get(i));
		}

		System.out.println(aulas.size());

		// lambda abaixo (para cada aula, executa o que tiver dentro de {}
		aulas.forEach(aula -> { // m�todo forEach do java 8 (n�o � comando)
			System.out.println("percorrendo:");
			System.out.println(aula);
		});

		aulas.add("Aumentando nosso conhecimento");
		System.out.println(aulas);

		Collections.sort(aulas); //usa o compareTo para ordenar lexicograficamente, a classe String ja implementa a interface Comparable com o metodo sobreescrito compareTo
		// Collections � uma classe auxiliar, diferente da interface Collecttion
		System.out.println("Depois de ordenado: ");
		System.out.println(aulas);

	}

}
