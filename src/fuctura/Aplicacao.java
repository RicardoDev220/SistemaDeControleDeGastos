package fuctura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import fuctura.util.DataSource;
import fuctura.util.FuncoesTela;
import fuctura.util.Menu;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);

		DataSource fonteDeDados = new DataSource();
		Connection conexao = fonteDeDados.getConnection();

		System.out.println("Precione enter para continuar!");
		entrada.nextLine();
		FuncoesTela.limparTela();

		Menu.exibir(entrada, conexao);
	}
}
