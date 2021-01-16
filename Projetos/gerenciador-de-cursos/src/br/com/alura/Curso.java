package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/*
 * List é uma sequência e aceita elementos duplicados. Set não aceita duplicados e não define ordem.
 */

public class Curso {
	
	private String nome;
	private String instrutor; //poderia fazer uma classe instrutor
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<Aluno>();
//	private Set<Aluno> alunos = new LinkedHashSet<Aluno>(); //mantem a ordem de inserção, mas nao podemos acessar com um get(index)
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>(); //hashmap usa do hashcode por ser tipo hash
//	private Map<Integer, Aluno> matriculaParaAluno = new LinkedHashMap<>(); //preserva a ordem de inserção
	
	public String getNome() {
		return nome;
	}
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getInstrutor() {
		return instrutor;
	}
	
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas); //programação defensiva, retorna uma lista readonly, não modificavel
		//acima: boa pratica para trabalhar com relacionamentos de objetos quando envolve coleções
	}
	
	public void adiciona(Aula aula) { //melhor dar o nome adiciona, pq o java ja é fortimente tipado
		this.aulas.add(aula);
	}
	
	public int getTempoTotal() {
		/*
		int tempoTotal = 0;
		for (Aula aula : aulas) {
			tempoTotal += aula.getTempo();
		}
		return tempoTotal;
		*/
		return this.aulas.stream().mapToInt(Aula::getTempo).sum(); //estilo java 8, usa o stream que veio a partir do java 8
	}
	
	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + ", aulas:" + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno); //contains de set utiliza do equals + hash code
		
	}

	public Aluno BuscaMatriculado(int numero) {
//		for (Aluno aluno : alunos) {
//			if (aluno.getNumeroMatricula() == numero) {
//				return aluno;
//			}
//		}
//		//return null; //má prática, ideal lançar uma exception
//		throw new NoSuchElementException("matricula não encontrada " + numero);

		if (!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException("matricula não encontrada " + numero);
		}
		return this.matriculaParaAluno.get(numero);
	}
	
	

}
