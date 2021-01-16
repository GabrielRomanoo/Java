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
 * ANOTA��ES
 * 
 * Optional � uma importante nova classe do Java 8. � com ele que 
 * poderemos trabalhar de uma maneira mais organizada com poss�veis valores null. 
 * Em vez de ficar comparando if(algumaCoisa == null), o Optional 
 * j� fornece uma s�rie de m�todos para nos ajudar nessas situa��es.
 * 
 * Ganhamos muito com essa nova introdu��o. 
 * Assim n�o precisamos escrever aqueles diversos ifs garantindo 
 * que o objeto n�o � nulo, temos uma forma muito mais interessante 
 * de representar nossas inten��es. A classe Optional nos oferece uma 
 * variedade imensa de novos m�todos que nos permite trabalhar de 
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
		
		//ver nas anota��es sobre o Optional
		Optional<Curso> optionalCurso = cursos.stream() 
			.filter(c -> c.getAlunos() >= 100)
			.findAny(); 
		
		optionalCurso.get(); //Dado um Optional, podemos pegar seu conte�do invocando o get. Ele vai devolver o Curso que queremos. Mas e se n�o houver nenhum? Uma exception ser� lan�ada.
		
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
			.collect(Collectors.toList()); //Collectors � cheio de factory methods
		
		//� atraves do collect e dos collectors que conseguimos "voltar" de uma stream para uma collection
		
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
