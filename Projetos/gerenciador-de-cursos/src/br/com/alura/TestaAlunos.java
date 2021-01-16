package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SET
 * Set � um conjunto, uma "sacola" onde os elementos est�o guardados.
 * Set n�o tem ordena��o, assim, n�o tem um index, uma posi��o
 * Set n�o aceita elementos repetidos.
 * Set � muito rapido para buscas por objetos, como em remove, contains, etc
 * 
 */

public class TestaAlunos {
	
	public static void main(String[] args) {
		
		//Set == Conjunto
		//Set<String> alunos = new HashSet<>(); //HashSet usa um Hash (tabela de espalhamento)
		Collection<String> alunos = new HashSet<>();
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Alberto Souza"); // n�o vai inserir, pois j� foi adicionado antes
		
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
		alunos.remove("Sergio Lopes");
		
		System.out.println(alunos.size());

		for (String aluno : alunos) {
			System.out.println(aluno);			
		}
		
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println(alunos);
		
		List<String> alunosEmLista = new ArrayList<>(alunos); //"transformando" set em list
		
	}

}
