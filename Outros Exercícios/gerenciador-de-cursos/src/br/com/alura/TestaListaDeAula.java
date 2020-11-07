package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {
	
	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revisitando as ArrayLists",21);
		Aula a2 = new Aula("Listas de Objetos", 20);
		Aula a3 = new Aula("Relacionamentos de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		System.out.println(aulas); //reescrita toString
				
		Collections.sort(aulas); //ordena perante o compareTo (classe tem que implementar o metodo comparable)
		System.out.println(aulas);
		
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo)); //ordena perante o tempo, "ordene estas aulas utilizando como comparação o retorno do método getTempo de cada Aula"
		//aulas.sort(Comparator.comparing(Aula::getTempo)); //veio no java 8, mesmo efeito da linha acima
		System.out.println(aulas);
		
	}

}
