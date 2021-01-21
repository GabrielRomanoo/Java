package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) { // try-with-resources (try-com-recursos)
	
			PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
			stm.setInt(1, 2);

			stm.execute();

			Integer linhasModificadas = stm.getUpdateCount(); // retorna o	 numero de linhas alteradas

			System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
		}
	}

}
