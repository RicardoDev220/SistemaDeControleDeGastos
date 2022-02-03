package fuctura.resitorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Tipo;

public class TipoRepositorio {
	public void inserir(Connection conexao, Tipo tipo) throws SQLException {
		String comandoSQL = "INSERT INTO tipo (codigo, nome) VALUES (?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(1, tipo.getCodigo());
		pstm.setString(2, tipo.getNome());
		
		pstm.execute();
	}
	
	public void excluir(Connection conexao, Tipo tipo) throws SQLException {
		String comandoSQL = "DELETE FROM tipo WHERE codigo = " + tipo.getCodigo();
		Statement stm = conexao.createStatement();
		stm.executeUpdate(comandoSQL);
	}
	
	public void alterar(Connection conexao, Tipo tipo) throws SQLException {
		String comandoSQL = "UPDATE tipo SET nome = ? WHERE codigo = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(2, tipo.getCodigo());
		pstm.setString(1, tipo.getNome());
		
		pstm.execute();
	}
	
	public ArrayList<Tipo> listarTodos(Connection conexao) throws SQLException{
		ArrayList<Tipo> tipos = new ArrayList<Tipo>();
		
		String comandoSQL = "SELECT * FROM tipo";
		Statement stm = conexao.createStatement();
		ResultSet resultadoDaConsulta = stm.executeQuery(comandoSQL);
		
		while (resultadoDaConsulta.next()) {
			int codigo = resultadoDaConsulta.getInt("codigo");
			String nome = resultadoDaConsulta.getString("nome");
			
			Tipo tipo = new Tipo(codigo, nome);
			
			tipos.add(tipo);
		}
		
		return tipos;
	}

}
