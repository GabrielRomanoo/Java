package br.com.alura.maven;

public class Produto { 
	
	private final String nome; //final é quando é uma variavel membro, nao pode ser alterada mais de uma vez
	private final double preco;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public double getPrecoComImposto() {
		return preco * 1.10;
	}
	
} 