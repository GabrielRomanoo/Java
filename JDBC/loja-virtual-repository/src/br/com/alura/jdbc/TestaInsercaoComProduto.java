package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) { // verificar se tem uma conexao disponivel
			
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
		}
		System.out.println(comoda);
	}
}
