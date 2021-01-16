package br.com.alura;

import java.util.Iterator;
import java.util.Set;

/*
 * Como um programador deve proceder n�o sabendo qual das implementa��es de Collection 
 * servir� melhor para o nosso sistema?
 * 
 * Provavelmente, caso a modelagem do sistema ainda n�o esteja bem definida, 
 * o desenvolvedor ir� utilizar a interface Collection<E>. 
 * Dessa maneira, ter� acesso aos m�todos b�sicos de todas as implementa��es, 
 * como size(), add(), remove() e contains(). 
 * Conforme for sentindo necessidade em algo espec�fico, o desenvolvedor far� poucas mudan�as em seu c�digo.
 * 
 * Caso sinta necessidade de fazer uma requisi��o a um elemento espec�fico atrav�s da sua posi��o, 
 * trocar� de Collection<E> para List<E>. Caso perceba que ordem n�o importa, 
 * por�m � necess�ria uma busca bem r�pida (e sem repeti��es), um Set<E> � mais apropriado.
 * 
 * Enquanto n�o sentir essa necessidade, provavelmente a Collection<E> ser� a melhor escolha.
 */

public class TestaCursoComAluno {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as colecoes do java", 
				"Paulo Silveira");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com cole��es", 22));
		
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
		System.out.println("E esse Turini, est� matriculado?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		System.out.println("O a1 � equals ao turini?");
		System.out.println(a1.equals(turini));
		
		// obrigatoriamente o seguinte � true
		
		System.out.println(a1.hashCode() == turini.hashCode());

	}

}
