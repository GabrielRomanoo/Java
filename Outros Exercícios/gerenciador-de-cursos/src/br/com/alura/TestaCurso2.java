package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestaCurso2 {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as colecoes do java", 
													"Paulo Silveira");
		
		//List<Aula> aulas = javaColecoes.getAulas(); //aulas aponta para a mesma referencia que getAulas
		//aulas.add(new Aula("Trabalhando com ArrayList", 21)); //mesma referencia do getAulas, iria mudar o List de lá tambem
		
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21)); //não é interessante fazer um add aula, e sim ter um metodo que faça isso
		//linha acima iria dar exception, pois getAulas retorna uma lista imutavel
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		//System.out.println(javaColecoes.getAulas()); //o getAulas devolve uma copia agora, por causa do metodo Collections.unmodifiableList
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aula = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aula);
		System.out.println(aula);
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes);
	
		
	}

}
