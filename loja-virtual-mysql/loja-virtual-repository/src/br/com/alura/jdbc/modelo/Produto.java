package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setId(int int1) {
		this.id = Integer.valueOf(int1);
	}

	@Override
	public String toString() {
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}
}
