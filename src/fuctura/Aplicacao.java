package fuctura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fuctura.model.Lancamento;
import fuctura.model.Senha;
import fuctura.model.Tag;
import fuctura.model.Tipo;
import fuctura.model.Usuario;
import fuctura.resitorio.LancamentoRepositorio;
import fuctura.resitorio.SenhaRepositorio;
import fuctura.util.DataSource;
import fuctura.util.Menu;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);

		DataSource fonteDeDados = new DataSource();
		Connection conexao = fonteDeDados.getConnection();

		Lancamento lancamento = new Lancamento();
		LancamentoRepositorio repositorioLancamento = new LancamentoRepositorio();

		Senha senha = new Senha();
		SenhaRepositorio repositorioSenha = new SenhaRepositorio();

		menuDeLancamento(entrada, lancamento, repositorioLancamento, conexao);
		menuDeSenha(entrada, senha, repositorioSenha, conexao);
	}

	public static void exibirLancamentos(ArrayList<Lancamento> lancamentos) {
		System.out.println("CÓDIGO|VALOR|DESCRIÇÃO");
		for (Lancamento lancamento : lancamentos) {
			System.out.print(" " + lancamento.getCodigo());
			System.out.print("    " + lancamento.getValor());
			System.out.println("  " + lancamento.getDescricao());
		}
	}

	public static void exibirSenhas(ArrayList<Senha> senhas) {
		System.out.println("CÓDIGO|VALOR");
		for (Senha senha : senhas) {
			System.out.print(" " + senha.getCodigo());
			System.out.println("    " + senha.getValor());
		}
	}
	
	public static void exibirTags(ArrayList<Tag> tags) {
		System.out.println("CÓDIGO|NOME");
		for (Tag tag : tags) {
			System.out.print(" " + tag.getCodigo());
			System.out.println("    " + tag.getNome());
		}
	}
	
	public static void exibirTipos(ArrayList<Tipo> tipos) {
		System.out.println("CÓDIGO|NOME");
		for (Tipo tipo : tipos) {
			System.out.print(" " + tipo.getCodigo());
			System.out.println("    " + tipo.getNome());
		}
	}

	public static void exibirUsuarios(ArrayList<Usuario> usuarios) {
		System.out.println("NOME   |   EMAIL  |IDADE");
		for (Usuario usuario : usuarios) {
			System.out.print(usuario.getNome());
			System.out.print("   " + usuario.getEmail());
			System.out.println("  " + usuario.getIdade());
		}
	}

	public static void limpar() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
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

	public static void menuDeLancamento(Scanner entrada, Lancamento lancamento, LancamentoRepositorio repositorio,
			Connection conexao) throws SQLException {
		Menu menu = new Menu();

		boolean exibirMenu = true;
		while (exibirMenu) {
			System.out.println(menu.stringMenuDeLancamento);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				lancamento = capturaDados(entrada, lancamento);
				repositorio.inserir(conexao, lancamento);
				break;
			case 2:
				lancamento = capturaDados(entrada, lancamento);
				repositorio.alterar(conexao, lancamento);
				break;
			case 3:
				lancamento = capturaDados(entrada, lancamento);
				repositorio.excluir(conexao, lancamento);
				break;
			case 4:
				ArrayList<Lancamento> lancamentos = repositorio.listarTodos(conexao);
				exibirLancamentos(lancamentos);
				break;
			case 5:
				System.out.println("Saindo.");
				exibirMenu = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			System.out.println("Precione enter para continuar!");
			entrada.nextLine();
			limpar();
		}
	}

	public static void menuDeSenha(Scanner entrada, Senha senha, SenhaRepositorio repositorio, Connection conexao)
			throws SQLException {
		Menu menu = new Menu();

		boolean exibirMenu = true;
		while (exibirMenu) {
			System.out.println(menu.stringMenuDeSenha);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				senha = capturaDados(entrada, senha);
				repositorio.inserir(conexao, senha);
				break;
			case 2:
				senha = capturaDados(entrada, senha);
				repositorio.alterar(conexao, senha);
				break;
			case 3:
				senha = capturaDados(entrada, senha);
				repositorio.excluir(conexao, senha);
				break;
			case 4:
				ArrayList<Senha> senhas = repositorio.listarTodos(conexao);
				exibirSenhas(senhas);
				break;
			case 5:
				System.out.println("Saindo.");
				exibirMenu = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			System.out.println("Precione enter para continuar!");
			entrada.nextLine();
			limpar();
		}
	}
}
