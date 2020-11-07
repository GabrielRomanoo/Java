package br.com.alura;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {
	
	private String nome;
	private String instrutor; //poderia fazer uma classe instrutor
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<Aluno>();
	
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
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
	

}
