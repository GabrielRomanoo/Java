package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

/* Quando indicamos a cardinalidade de um atributo para jpa, ela faz as ligações por debaixo dos panos */

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento para a chave primaria
	private Long id;
	
	
	@Enumerated(EnumType.STRING) //dizemos para a jpa que queremos persistir a string dessa enum
	private TipoMovimentacao tipoMovimentacao;
	private String descricao;
	private LocalDateTime data;
	private BigDecimal valor; //tem mais precisão do que o double para trabalhar com dinheiro
	
	/* CARDINALIDADE */
	@ManyToOne //indicamos para jpa que podem existir varias movimentações pra uma conta (ou uma conta pode ter varias movimentações)
	private Conta conta;
	
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
}
