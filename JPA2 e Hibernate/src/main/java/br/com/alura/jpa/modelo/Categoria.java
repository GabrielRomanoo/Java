package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Deprecated //para mostrar que este construtor nao deve ser usado por nos, e esta aqui apenas para fim do hibernate, fim de infraestrutura
	public Categoria() { //o hibernate precisa ter o construtor padrao
	}
	
	public Categoria(String nome) { //se criamos um construtor, temos que explicitar o construtor padrao sem nada, para o hibernate poder usar
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome + " - " + id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
