package fuctura.resitorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Usuario;

public class UsuarioRepositorio {
	public void inserir(Connection conexao, Usuario usuario) throws SQLException {
		String comandoSQL = "INSERT INTO usuario (nome, email, idade) VALUES (?, ?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setString(1, usuario.getNome());
		pstm.setString(2, usuario.getEmail());
		pstm.setInt(3, usuario.getIdade());
		
		pstm.execute();
	}
	
	public void excluir(Connection conexao, Usuario usuario) throws SQLException {
		String comandoSQL = "DELETE FROM usuario WHERE email = " + usuario.getEmail();
		Statement stm = conexao.createStatement();
		stm.executeUpdate(comandoSQL);
	}
	
	public void alterar(Connection conexao, Usuario usuario) throws SQLException {
		String comandoSQL = "UPDATE usuario SET nome = ?, idade = ? WHERE email = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);

		pstm.setString(1, usuario.getNome());
		pstm.setInt(2, usuario.getIdade());
		pstm.setString(3, usuario.getEmail());
		
		pstm.execute();
	}
	
	public ArrayList<Usuario> listarTodos(Connection conexao) throws SQLException{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String comandoSQL = "SELECT * FROM usuario";
		Statement stm = conexao.createStatement();
		ResultSet resultadoDaConsulta = stm.executeQuery(comandoSQL);
		
		while (resultadoDaConsulta.next()) {
			String nome = resultadoDaConsulta.getString("nome");
			String email = resultadoDaConsulta.getString("email");
			int idade = resultadoDaConsulta.getInt("idade");
			
			Usuario usuario = new Usuario(nome, email, idade);
			
			usuarios.add(usuario);
		}
		
		return usuarios;
	}
}
