package br.com.alura.java.io.teste;

import java.io.Serializable;

/**
 * Classe que representa um cliente no Bytebank
 * 
 * @author Gabriel Romano
 * @version 0.1
 */

/*
 * Ao implementarmos Serializable, admitimos que estes objetos podem ser transformados 
 * em um fluxo de bits e bytes. Portanto, devemos refletir isso no atributo estático 
 * do serialVersionUID, e administra-lo.
 * 
 * Isso significa que começamos com uma versão, 1L por exemplo, e precisamos prestar 
 * atenção às mudanças na classe, caso haja uma incompatível com o fluxo de bits e bytes 
 * que já foi gravado, com base nos objetos desta classe, precisamos aumentar o número 
 * da versão, desta forma deixando claro que a mudança foi incompatível.
 * 
 * Cada alteração nos atributos, por exemplo a sua inclusão ou exclusão, 
 * merece uma alteração no número na versão.
 * 
 * O serialVersionUID é da classe (por isso estático) e define a versão ou 
 * identificação numérica da classe. Cada vez que alteramos algo incompatível na classe, 
 * devemos alterar o seu valor.
 * 
 * Sempre quando serializamos o objeto, também será serializado o valor do serialVersionUID.
 * 
 */

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//O serialVersionUID define a versão atual da classe e esse valor fica gravado na representação binária do objeto.
	
	private String nome;
	private String cpf;
	private String profissao;
	
	public String getNomeCpf() {
		return this.nome + ", " + this.cpf;		
	}
	
	public String getNomeCpfProfissao() {
		return this.nome + ", " + this.cpf + ", " + this.profissao;		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
