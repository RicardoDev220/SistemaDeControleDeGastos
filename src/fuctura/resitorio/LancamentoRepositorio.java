package fuctura.resitorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Lancamento;

public class LancamentoRepositorio {
	public void inserir(Connection conexao, Lancamento lancamento) throws SQLException {
		String comandoSQL = "INSERT INTO lancamento (codigo, valor, descricao) VALUES (?, ?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(1, lancamento.getCodigo());
		pstm.setDouble(2, lancamento.getValor());
		pstm.setString(3, lancamento.getDescricao());
		
		pstm.execute();
	}
	
	public void excluir(Connection conexao, Lancamento lancamento) throws SQLException {
		String comandoSQL = "DELETE FROM lancamento WHERE codigo = " + lancamento.getCodigo();
		Statement stm = conexao.createStatement();
		stm.executeUpdate(comandoSQL);
	}
	
	public void alterar(Connection conexao, Lancamento lancamento) throws SQLException {
		String comandoSQL = "UPDATE lancamento SET valor = ?, descricao = ? WHERE codigo = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
		
		pstm.setInt(3, lancamento.getCodigo());
		pstm.setDouble(1, lancamento.getValor());
		pstm.setString(2, lancamento.getDescricao());
		
		pstm.execute();
	}
	
	public ArrayList<Lancamento> listarTodos(Connection conexao) throws SQLException{
		ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();
		
		String comandoSQL = "SELECT * FROM lancamento";
		Statement stm = conexao.createStatement();
		ResultSet resultadoDaConsulta = stm.executeQuery(comandoSQL);
		
		while (resultadoDaConsulta.next()) {
			int codigo = resultadoDaConsulta.getInt("codigo");
			double valor = resultadoDaConsulta.getDouble("valor");
			String descricao = resultadoDaConsulta.getString("descricao");
			
			Lancamento lancamento = new Lancamento(codigo, valor, descricao);
			
			lancamentos.add(lancamento);
		}
		
		return lancamentos;
	}
}
