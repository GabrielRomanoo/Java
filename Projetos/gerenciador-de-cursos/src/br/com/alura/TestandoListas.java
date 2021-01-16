package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

/* 
 * ANOTAÇÕES
 * -----------------------------------------------------------------------
 * AULA 01
 * 
 * System.out.println(aulas); // toString
 * Qual é o resultado desse código? Ele mostra as aulas adicionadas em sequência! 
 * Por que isso acontece? Pois a classe ArrayList, ou uma de suas mães, 
 * reescreveu o método toString, para que internamente fizesse um for, 
 * concatenando os seus elementos internos separados por vírgula.
 * 
 * aulas.remove(0);
 * Por que 0? Pois as listas, assim como a maioria dos casos no Java, 
 * são indexadas a partir do 0, e não do 1.
 * 
 * for (String aula : aulas) {...
 * O for de uma maneira especial, chamada de enhanced for, 
 * ou popularmente foreach. Lembrando que foreach não existe 
 * no Java como comando, e sim como um caso especial do for mesmo.
 * 
 * aulas.forEach(aula -> {...});
 * Uma outra forma de percorrer nossa lista é utilizando as sintaxes e 
 * métodos novos incluídos no Java 8. Temos um método (não um comando!) 
 * agora que se chama forEach. Ele recebe um objeto do tipo Consumer, 
 * mas o interessante é que você não precisa criá-lo, você pode utilizar 
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

		// foreach/enhanced for (não é comando, serve apenas para o eclipse)
		for (String aula : aulas) { // para cada aula dentro de aulas
			System.out.println("Aula: " + aula);
		}

		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é " + primeiraAula);

		// "substitui o enhanced for, mas não é eficiente
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("aula: " + aulas.get(i));
		}

		System.out.println(aulas.size());

		// lambda abaixo (para cada aula, executa o que tiver dentro de {}
		aulas.forEach(aula -> { // método forEach do java 8 (não é comando)
			System.out.println("percorrendo:");
			System.out.println(aula);
		});

		aulas.add("Aumentando nosso conhecimento");
		System.out.println(aulas);

		Collections.sort(aulas); //usa o compareTo para ordenar lexicograficamente, a classe String ja implementa a interface Comparable com o metodo sobreescrito compareTo
		// Collections é uma classe auxiliar, diferente da interface Collecttion
		System.out.println("Depois de ordenado: ");
		System.out.println(aulas);

	}

}
