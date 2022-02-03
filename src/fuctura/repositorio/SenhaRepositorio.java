package fuctura.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Senha;

public class SenhaRepositorio {
	public void inserir(Connection conexao, Senha senha) throws SQLException {
		String comandoSQL = "INSERT INTO senha (codigo, valor) VALUES (?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(1, senha.getCodigo());
		pstm.setString(2, senha.getValor());
		
		pstm.execute();
	}
	
	public void excluir(Connection conexao, Senha senha) throws SQLException {
		String comandoSQL = "DELETE FROM senha WHERE codigo = " + senha.getCodigo();
		Statement stm = conexao.createStatement();
		stm.executeUpdate(comandoSQL);
	}
	
	public void alterar(Connection conexao, Senha senha) throws SQLException {
		String comandoSQL = "UPDATE senha SET valor = ? WHERE codigo = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(2, senha.getCodigo());
		pstm.setString(1, senha.getValor());
		
		pstm.execute();
	}
	
	public ArrayList<Senha> listarTodos(Connection conexao) throws SQLException{
		ArrayList<Senha> senhas = new ArrayList<Senha>();
		
		String comandoSQL = "SELECT * FROM senha";
		Statement stm = conexao.createStatement();
		ResultSet resultadoDaConsulta = stm.executeQuery(comandoSQL);
		
		while (resultadoDaConsulta.next()) {
			int codigo = resultadoDaConsulta.getInt("codigo");
			String valor = resultadoDaConsulta.getString("valor");
			
			Senha senha = new Senha(codigo, valor);
			
			senhas.add(senha);
		}
		
		return senhas;
	}
}
