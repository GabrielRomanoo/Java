package br.com.alura;

public class Aluno {
	
	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		if (nome == null) { //programação defensiva
			throw new NullPointerException("nome nao pode ser null");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	@Override
	public String toString() {
		return "[Aluno: " + this.nome + ", Matricula: " + this.numeroMatricula + "]";
	}
	
	/* FORMA SIMPLES */
	@Override //sem reescrever o equals, o contains usaria o equals padrão de object
	public boolean equals(Object obj) {
		Aluno outro = (Aluno) obj;
		return this.nome.equals(outro.nome); //usa o equals de nome, que é uma String
	}
	
//	 * REGRA: 
//	 * sempre que reescrever o equals, tem que reescrever o hashcode

	@Override 
	public int hashCode() {
		//return this.nome.charAt(0); //forma ingênua, pois ja tem o metodo hashcode na string
		return this.nome.hashCode();
	}
	
	
   /* FORMA FEITA PELA IDE 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroMatricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroMatricula != other.numeroMatricula)
			return false;
		return true;
	}
	*/
	

	
	
}

