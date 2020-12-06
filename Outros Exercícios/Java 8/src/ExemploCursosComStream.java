import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * ANOTAÇÕES
 * 
 * Toda Collection, a partir do Java 8, tem um metodo chamado Stream.
 * O método Stream devolve um fluxo de objetos.
 * 
 * As modificações em um stream não modificam a coleção/objeto que o gerou. 
 * Tudo que é feito nesse fluxo de objetos, nesse Stream, não impacta, 
 * não tem efeitos colaterais na coleção original. 
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

public class ExemploCursosComStream {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Java Script", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(c -> c.getAlunos())); //ideal usar o comparingInt
		cursos.sort(Comparator.comparingInt(Curso::getAlunos)); 
		
//		cursos.forEach(System.out::println); //imprime o toString da classe Curso
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		/* forma antiga
		for (Curso curso : cursos) {
			if (curso.getAlunos() >= 100) 
				System.out.println(curso.getNome());
		} */
		
		cursos.stream() //ver anotações
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.map(c -> c.getAlunos()) //o ideal era usar o mapToInt
			.forEach(total -> System.out.println(total));
		
		//Variacoes
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100) 
			.map(Curso::getAlunos) 
			.forEach(System.out::println);
		
		IntStream stream = cursos.stream()
			.filter(c -> c.getAlunos() >= 100) 
			.mapToInt(Curso::getAlunos);
		
		stream.forEach(System.out::println);
		
		Stream<String> map = cursos.stream().map(Curso::getNome);
		map.forEach(System.out::println);
		
		int sum = cursos.stream()
				.filter(c -> c.getAlunos() >= 100) 
				.mapToInt(Curso::getAlunos)
				.sum();
		
		System.out.println(sum);
	}

}
