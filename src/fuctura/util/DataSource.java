package fuctura.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import fuctura.model.Lancamento;
import fuctura.model.Senha;
import fuctura.model.Tag;
import fuctura.model.Tipo;
import fuctura.model.Usuario;

public class DataSource {
	public Connection getConnection() throws SQLException {
		String URL ="jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "fuctura";
		String senha = "123";
		
		Connection conexao = DriverManager.getConnection(URL, usuario, senha);
		
		System.out.println("Conectado com sucesso!");
		
		return conexao;
	}

	public static Lancamento capturaDados(Scanner entrada, Lancamento lancamento) {
		System.out.print("Digite o código do lançamento: ");
		lancamento.setCodigo(Integer.valueOf(entrada.nextLine()));

		System.out.print("Digite a descrição do lançamento: ");
		lancamento.setDescricao(entrada.nextLine());

		System.out.print("Digite o valor do lançamento: ");
		lancamento.setValor(Double.valueOf(entrada.nextLine()));

		return lancamento;
	}

	public static Senha capturaDados(Scanner entrada, Senha senha) {
		System.out.print("Digite o código da senha: ");
		senha.setCodigo(Integer.valueOf(entrada.nextLine()));

		System.out.print("Digite o valor da senha: ");
		senha.setValor(entrada.nextLine());

		return senha;
	}

	public static Tag capturaDados(Scanner entrada, Tag tag) {
		System.out.print("Digite o código da tag: ");
		tag.setCodigo(Integer.valueOf(entrada.nextLine()));

		System.out.print("Digite o nome da tag: ");
		tag.setNome(entrada.nextLine());

		return tag;
	}

	public static Tipo capturaDados(Scanner entrada, Tipo tipo) {
		System.out.print("Digite o código do tipo: ");
		tipo.setCodigo(Integer.valueOf(entrada.nextLine()));

		System.out.print("Digite o nome do tipo: ");
		tipo.setNome(entrada.nextLine());

		return tipo;
	}

	public static Usuario capturaDados(Scanner entrada, Usuario usuario) {
		System.out.print("Digite o nome do usuario: ");
		usuario.setNome(entrada.nextLine());

		System.out.print("Digite o email do usuario: ");
		usuario.setEmail(entrada.nextLine());

		System.out.print("Digite a idade do usuario: ");
		usuario.setIdade(Integer.valueOf(entrada.nextLine()));

		return usuario;
	}
}
