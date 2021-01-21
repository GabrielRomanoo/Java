package br.com.alura.jdbc.modelo;

public class Categoria {
	
	private Integer id;
	private String nome;
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
