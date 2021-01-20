package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

/* DAO é um patterns, um padrão de projeto */
/* um lugar unico para acessar o repositori de dados, afim de isolar o codigo e evitar repetição */
public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());

			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}
}
