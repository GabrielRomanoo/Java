package usandoOptional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * ANOTAÇÕES
 * 
 * Optional é uma importante nova classe do Java 8. É com ele que 
 * poderemos trabalhar de uma maneira mais organizada com possíveis valores null. 
 * Em vez de ficar comparando if(algumaCoisa == null), o Optional 
 * já fornece uma série de métodos para nos ajudar nessas situações.
 * 
 * Ganhamos muito com essa nova introdução. 
 * Assim não precisamos escrever aqueles diversos ifs garantindo 
 * que o objeto não é nulo, temos uma forma muito mais interessante 
 * de representar nossas intenções. A classe Optional nos oferece uma 
 * variedade imensa de novos métodos que nos permite trabalhar de 
 * forma funcional com nossos valores, tirando maior proveito dos 
 * novos recursos de default methods, lambdas e method reference. 
 * 
 * 
 * 
 */

class Curso {
	
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursosComStreamAvancado {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Java Script", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos)); 

		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
		System.out.println(sum);
		
		//ver nas anotações sobre o Optional
		Optional<Curso> optionalCurso = cursos.stream() 
			.filter(c -> c.getAlunos() >= 100)
			.findAny(); 
		
		optionalCurso.get(); //Dado um Optional, podemos pegar seu conteúdo invocando o get. Ele vai devolver o Curso que queremos. Mas e se não houver nenhum? Uma exception será lançada.
		
		Curso curso = optionalCurso.orElse(null); //resolve o problema da execao do get acima, mas ainda retorna null, o que pode dar problema no sysout abaixo
		//System.out.println(curso.getNome());
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome())); //resolve os dois problemas acima
	
		//O JEITO IDEAL: fazer direto
		
		cursos.stream() 
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
		//-------------------------------------------------------------
		
		OptionalDouble media = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.average();

		//para alterar o curso original:
		
		//List<Curso> resultado = cursos.stream()
		cursos = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList()); //Collectors é cheio de factory methods
		
		//é atraves do collect e dos collectors que conseguimos "voltar" de uma stream para uma collection
		
		Map<String, Integer> map = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos())); 
		
		map.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		cursos.parallelStream() //usando threads
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos")); 
		
	
	}
}
