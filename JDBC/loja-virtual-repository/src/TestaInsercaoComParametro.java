import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		String nome = "Mouse'"; //erro do usuario
		String descricao = "Mouse sem fio); delete from Produto;"; //possivel vulnerabilidade

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		connection.setAutoCommit(false); //tira a responsabilidade de commitar do jdbc
		
		try {
			//com o preparedstatement, o jdbc faz a validação do comando sql, a fim de nao ter possiveis erros nos parametros passados	
			
			PreparedStatement stm = connection
					.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
							Statement.RETURN_GENERATED_KEYS);  //novo paramentro para retornar o id do produto inserido
			
			adicionar("SmartTV", "45 polegadas", stm);
			adicionar("Radio", "Radio de bateria", stm);
			
			connection.commit();
					
			stm.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();			
		}
		connection.close();
	}

	private static void adicionar(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		/*
		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		} */
		
		stm.execute(); 
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

		rst.close();
	}
}