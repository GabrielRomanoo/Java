import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		//crio a query
		Statement stm = con.createStatement(); //statement no java sao os comandos no sql
		
		//executo a query
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO"); //para select, o execute devolve true. para delete, uptade, alter, ele devolve false
		
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
		
		con.close();
	}
}