package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity //Para indicar para jpa que a classe é uma entidade, uma tabela dentro do banco de dados.
public class Conta {

	@Id //Para indicar qual atributo representa a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Para indicar qual atributo representa a chave primária
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;
	
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER) //mapeamento bidirecional, espelho. dizemos para a jpa que este relacionamento ja esta mapeado na outra ponta, em movimentacao @ManyToOne da classe Movimentacao
	private List<Movimentacao> movimentacoes; //a conta conhece todas as suas movimentacoes 
	
	// com o mappedby conseguimos manter o @OneToMany apenas como um espelho (bidirecional) evitando que ele crie duas vezes o relacionamento no banco(chave estrangeira e tabela de relacionamento)
	// o atributo movimentacoes é o lado fraco, pois nao causa nenhuma mudança no banco. quem possui a chave estrangeira é a entidade movimentacao, que possui o atributo conta (lado forte)
	// todos os relacionamentos mapeados como ...ToMany são por padrao lazyness (carregamento preguiçoso), ou seja, na query, este relacionamento só irá ser carregado ser for realmente necessário
	// na anotação (configuração), colocamos o fetch como EAGER, ou seja, ele sempre irá carregar o relacionamento, mesmo que nao seja usado. O tipo LAIZY é para carregamento de dados por demanda.
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