package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/* classe para isolar, encapsular a chamada do driver manager */
public class ConnectionFactory {
	
	public DataSource dataSource;
	
	/* criando o pool de conexões e configurando */
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource(); // c3p0
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		comboPooledDataSource.setMaxPoolSize(15); //numero maximo de conexoes no pool
		
		this.dataSource = comboPooledDataSource; 
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
}
	

//	public Connection recuperarConexao() throws SQLException {
//		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
//				"root", "root");
//	}

}
