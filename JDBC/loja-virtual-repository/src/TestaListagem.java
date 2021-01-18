import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory(); //poderia ter criado o metodo de forma estatica
		
		Connection connection = connectionFactory.recuperarConexao();		
		//crio a query
//		Statement stm = connection.createStatement(); //statement no java sao os comandos no sql
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO"); //statement no java sao os comandos no sql

		
		//executo a query
		stm.execute(); //para select, o execute devolve true. para delete, uptade, alter, ele devolve false
		
		//pego o resultado
		ResultSet resultado = stm.getResultSet();
		
		while (resultado.next()) {
			Integer id = resultado.getInt("ID"); //se fosse pegar pelo index, teria que pegar a partir do 1, porque no sql ele conta aprtir do 1
			System.out.println(id);
			String nome = resultado.getString("NOME");
			System.out.println(nome);
			String descricao = resultado.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		connection.close();
	}
}