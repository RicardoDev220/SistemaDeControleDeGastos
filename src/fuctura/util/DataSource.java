package fuctura.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public Connection getConnection() throws SQLException {
		String URL ="jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "fuctura";
		String senha = "123";
		
		Connection conexao = DriverManager.getConnection(URL, usuario, senha);
		
		System.out.println("Conectado com sucesso!");
		
		return conexao;
	}
}
