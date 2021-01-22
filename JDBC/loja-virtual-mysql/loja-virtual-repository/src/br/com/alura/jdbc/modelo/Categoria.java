package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
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
	
	public Integer getId() {
		return this.id;
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

}
