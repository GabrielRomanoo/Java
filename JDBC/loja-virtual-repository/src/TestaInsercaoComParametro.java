import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		String nome = "Mouse'"; //erro do usuario
		String descricao = "Mouse sem fio); delete from Produto;"; //possivel vulnerabilidade

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		//com o preparedstatement, o jdbc faz a validação do comando sql, a fim de nao ter possiveis erros nos parametros passados

		PreparedStatement stm = connection
				.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);  //novo paramentro para retornar o id do produto inserido
		
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute(); 
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

		connection.close();
	}
}