package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity //Para indicar para jpa que a classe � uma entidade, uma tabela dentro do banco de dados.
public class Conta {

	@Id //Para indicar qual atributo representa a chave prim�ria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para indicar qual atributo representa a chave prim�ria
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;
	
	@OneToMany(mappedBy = "conta") //mapeamento bidirecional, espelho. dizemos para a jpa que este relacionamento ja esta mapeado na outra ponta, em movimentacao @ManyToOne da classe Movimentacao
	private List<Movimentacao> movimentacoes; //a conta conhece todas as suas movimentacoes 
	// com o mappedby conseguimos manter o @OneToMany apenas como um espelho (bidirecional) evitando que ele crie duas vezes o relacionamento no banco(chave estrangeira e tabela de relacionamento)
	// o atributo movimentacoes � o lado fraco, pois nao causa nenhuma mudan�a no banco. quem possui a chave estrangeira � a entidade movimentacao, que possui o atributo conta (lado forte)
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Movimentacao> getMovimentacoes() {
		return this.movimentacoes;
	}
}