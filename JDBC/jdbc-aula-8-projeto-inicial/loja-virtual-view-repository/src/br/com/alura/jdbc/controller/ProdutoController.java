package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoController() {
		Connection connection = new ConnectionFactory().recuperarConexao(); //recuperamos a conexao com o banco
		this.produtoDAO = new ProdutoDAO(connection); //passamos a conexao para a DAO
	}
	
	public void deletar(Integer id) {
		System.out.println("Deletando produto");
		this.produtoDAO.deletar(id);
	}

	public void salvar(Produto produto) {
		System.out.println("Salvando produto");
		this.produtoDAO.salvar(produto);
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		System.out.println("Alterando produto");
		this.produtoDAO.alterar(nome, descricao, id);
	}
}
