package fuctura.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Tag;

public class TagRepositorio {
	public void inserir(Connection conexao, Tag tag) throws SQLException {
		String comandoSQL = "INSERT INTO tag (codigo, nome) VALUES (?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(1, tag.getCodigo());
		pstm.setString(2, tag.getNome());
		
		pstm.execute();
	}
	
	public void excluir(Connection conexao, Tag tag) throws SQLException {
		String comandoSQL = "DELETE FROM tag WHERE codigo = " + tag.getCodigo();
		Statement stm = conexao.createStatement();
		stm.executeUpdate(comandoSQL);
	}
	
	public void alterar(Connection conexao, Tag tag) throws SQLException {
		String comandoSQL = "UPDATE tag SET nome = ? WHERE codigo = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(2, tag.getCodigo());
		pstm.setString(1, tag.getNome());
		
		pstm.execute();
	}
	
	public ArrayList<Tag> listarTodos(Connection conexao) throws SQLException{
		ArrayList<Tag> tags = new ArrayList<Tag>();
		
		String comandoSQL = "SELECT * FROM tag";
		Statement stm = conexao.createStatement();
		ResultSet resultadoDaConsulta = stm.executeQuery(comandoSQL);
		
		while (resultadoDaConsulta.next()) {
			int codigo = resultadoDaConsulta.getInt("codigo");
			String nome = resultadoDaConsulta.getString("nome");
			
			Tag tag = new Tag(codigo, nome);
			
			tags.add(tag);
		}
		
		return tags;
	}
}
