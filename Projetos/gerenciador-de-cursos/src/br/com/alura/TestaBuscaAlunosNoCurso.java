package br.com.alura;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as colecoes do java", "Paulo Silveira");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		Aluno a4 = new Aluno("Paulo Silveira", 5617);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		javaColecoes.matricula(a4); 
		// não vai dar problema, porque no nosso set um aluno só é 
		// equals ao outro quando eles tem o mesmo nome, 
		// nao a mesma matricula

		System.out.println(javaColecoes.getAlunos()); //substitui o guilherme, para resolver, ver mais abaixo
		System.out.println("Quem é o aluno com matricula 5617?");
		Aluno aluno = javaColecoes.BuscaMatriculado(5617);
		System.out.println(aluno);

	}

}
