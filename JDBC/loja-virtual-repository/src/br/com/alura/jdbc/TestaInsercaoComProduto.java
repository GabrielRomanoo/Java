package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) { // verificar se tem uma conexao disponivel

			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
			
			try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				stm.setString(1, comoda.getNome());
				stm.setString(2, comoda.getDescricao());
				
				stm.execute();
				
				try (ResultSet rst = stm.getGeneratedKeys()) {
					while (rst.next()) {
						comoda.setId(rst.getInt(1));
					}
				}

			} 
		}
		System.out.println(comoda);
	}
}
