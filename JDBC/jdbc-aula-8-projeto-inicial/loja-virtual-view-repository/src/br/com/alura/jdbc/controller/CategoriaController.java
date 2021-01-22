package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao(); // criamos uma conexão
		this.categoriaDAO = new CategoriaDAO(connection); // passamos a conexao para DAO
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar(); //responsabilidade de manipular o banco é da DAO
	}
}
