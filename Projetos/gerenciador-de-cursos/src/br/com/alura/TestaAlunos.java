package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SET
 * Set é um conjunto, uma "sacola" onde os elementos estão guardados.
 * Set não tem ordenação, assim, não tem um index, uma posição
 * Set não aceita elementos repetidos.
 * Set é muito rapido para buscas por objetos, como em remove, contains, etc
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
		alunos.add("Alberto Souza"); // não vai inserir, pois já foi adicionado antes
		
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
