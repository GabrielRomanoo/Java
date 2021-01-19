package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Por que, ao utilizar o try-with-resources, não é mais necessário explicitar o close para fechar o statements (ResultSet, Connection, PreparedStatement)?
 * Estendendo o AutoCloseable, o try-with-resources executa o método close sem que precise estar explícito.
 */

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		String nome = "Mouse'"; // erro do usuario
		String descricao = "Mouse sem fio); delete from Produto;"; // possivel vulnerabilidade

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			connection.setAutoCommit(false); // tira a responsabilidade de commitar do jdbc

			// com o preparedstatement, o jdbc faz a validação do comando sql, a fim de nao
			// ter possiveis erros nos parametros passados
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS)) { /* novo paramentro para retornar o id do produto inserido */

				adicionar("SmartTV", "45 polegadas", stm);
				adicionar("Radio", "Radio de bateria", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionar(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		/*
		 * if (nome.equals("Radio")) { throw new
		 * RuntimeException("Não foi possivel adicionar o produto"); }
		 */

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) { /* com o try-with-resources, ele irá fechar automaticamente o rst, pois o rst extende uma classe chamada  AutoClose */

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}

		}
	}
}