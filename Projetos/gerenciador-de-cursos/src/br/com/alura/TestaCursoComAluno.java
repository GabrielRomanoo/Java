package br.com.alura;

import java.util.Iterator;
import java.util.Set;

/*
 * Como um programador deve proceder não sabendo qual das implementações de Collection 
 * servirá melhor para o nosso sistema?
 * 
 * Provavelmente, caso a modelagem do sistema ainda não esteja bem definida, 
 * o desenvolvedor irá utilizar a interface Collection<E>. 
 * Dessa maneira, terá acesso aos métodos básicos de todas as implementações, 
 * como size(), add(), remove() e contains(). 
 * Conforme for sentindo necessidade em algo específico, o desenvolvedor fará poucas mudanças em seu código.
 * 
 * Caso sinta necessidade de fazer uma requisição a um elemento específico através da sua posição, 
 * trocará de Collection<E> para List<E>. Caso perceba que ordem não importa, 
 * porém é necessária uma busca bem rápida (e sem repetições), um Set<E> é mais apropriado.
 * 
 * Enquanto não sentir essa necessidade, provavelmente a Collection<E> será a melhor escolha.
 */

public class TestaCursoComAluno {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as colecoes do java", 
				"Paulo Silveira");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos os alunos matriculados: ");
//		javaColecoes.getAlunos().forEach(a -> { /*para cada aluno "a" */
//			System.out.println(a); //pega o toString de Aluno
//		});
		
//		for (Aluno a: javaColecoes.getAlunos()) {
//			System.out.println(a);
//		}
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		while (iterador.hasNext()) {
			Aluno proximo = iterador.next();
			System.out.println(proximo);
		}
		
		System.out.println("O aluno "+ a1.getNome() + "esta matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		System.out.println("E esse Turini, está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		System.out.println("O a1 é equals ao turini?");
		System.out.println(a1.equals(turini));
		
		// obrigatoriamente o seguinte é true
		
		System.out.println(a1.hashCode() == turini.hashCode());

	}

}
