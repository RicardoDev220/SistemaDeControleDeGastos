package fuctura.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fuctura.model.Lancamento;
import fuctura.model.Senha;
import fuctura.model.Tag;
import fuctura.model.Tipo;
import fuctura.model.Usuario;
import fuctura.repositorio.LancamentoRepositorio;
import fuctura.repositorio.SenhaRepositorio;
import fuctura.repositorio.TagRepositorio;
import fuctura.repositorio.TipoRepositorio;
import fuctura.repositorio.UsuarioRepositorio;
import fuctura.util.DataSource;
import fuctura.util.FuncoesTela;

public class Menu {
	private static String stringMenuInicial = 		"+----------------------------+\n" + 
													"|            Menu            |\n" + 
													"+----------------------------+\n" + 
													"|Opção 1 - Menu de lancamento|\n" + 
													"|Opção 2 - Menu de senha     |\n" + 
													"|Opção 3 - Menu de tag       |\n" + 
													"|Opção 4 - Menu de tipo      |\n" + 
													"|Opção 5 - Menu de usuários  |\n" +
													"|Opção 6 - Sair              |\n" +
													"+----------------------------+\n";
	private static String stringMenuDeLancamentos = "+----------------------------+\n" + 
													"|     Menu de Lançamentos    |\n" + 
													"+----------------------------+\n" + 
												    "|Opção 1 - Inserir lançamento|\n" + 
												    "|Opção 2 - Alterar lançamento|\n" + 
												    "|Opção 3 - Excluir lançamento|\n" + 
												    "|Opção 4 - Listar lançamentos|\n" + 
												    "|Opção 5 - Sair              |\n" +
												    "+----------------------------+\n";
	private static String stringMenuDeSenhas = 		"+-----------------------+\n" + 
													"|     Menu de Senhas    |\n" + 
											   		"+-----------------------+\n" + 
											   		"|Opção 1 - Inserir senha|\n" + 
											   		"|Opção 2 - Alterar senha|\n" + 
											   		"|Opção 3 - Excluir senha|\n" + 
											   		"|Opção 4 - Listar senhas|\n" + 
											   		"|Opção 5 - Sair         |\n" +
											   		"+-----------------------+\n";
	private static String stringMenuDeTags = 		"+---------------------+\n" + 
													"|     Menu de Tags    |\n" + 
											 		"+---------------------+\n" + 
											 		"|Opção 1 - Inserir tag|\n" + 
											 		"|Opção 2 - Alterar tag|\n" + 
											 		"|Opção 3 - Excluir tag|\n" + 
											 		"|Opção 4 - Listar tags|\n" + 
											 		"|Opção 5 - Sair       |\n" +
											 		"+---------------------+\n";
	private static String stringMenuDeTipos = 		"+----------------------+\n" + 
													"|     Menu de Tipos    |\n" + 
											  		"+----------------------+\n" + 
											  		"|Opção 1 - Inserir tipo|\n" + 
											  		"|Opção 2 - Alterar tipo|\n" + 
											  		"|Opção 3 - Excluir tipo|\n" + 
											  		"|Opção 4 - Listar tipos|\n" + 
											  		"|Opção 5 - Sair        |\n" +
											  		"+----------------------+\n";
	private static String stringMenuDeUsuarios = 	"+-------------------------+\n" + 
													"|     Menu de Usuários    |\n" + 
												 	"+-------------------------+\n" + 
												 	"|Opção 1 - Inserir usuário|\n" + 
												 	"|Opção 2 - Alterar usuário|\n" + 
												 	"|Opção 3 - Excluir usuário|\n" + 
												 	"|Opção 4 - Listar usuários|\n" + 
												 	"|Opção 5 - Sair           |\n" +
												 	"+-------------------------+\n";
	
	public static void exibir(Scanner entrada, Connection conexao) throws SQLException {
		Lancamento lancamento = new Lancamento();
		LancamentoRepositorio repositorioLancamento = new LancamentoRepositorio();

		Senha senha = new Senha();
		SenhaRepositorio repositorioSenha = new SenhaRepositorio();
		
		Tag tag = new Tag();
		TagRepositorio repositorioTag = new TagRepositorio();
		
		Tipo tipo = new Tipo();
		TipoRepositorio repositorioTipo = new TipoRepositorio();
		
		Usuario usuario = new Usuario();
		UsuarioRepositorio repositorioUsuario = new UsuarioRepositorio();

		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuInicial);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				exibirMenuDeLancamentos(entrada, lancamento, repositorioLancamento, conexao);
				break;
			case 2:
				exibirMenuDeSenhas(entrada, senha, repositorioSenha, conexao);
				break;
			case 3:
				exibirMenuDeTags(entrada, tag, repositorioTag, conexao);
				break;
			case 4:
				exibirMenuDeTipos(entrada, tipo, repositorioTipo, conexao);
				break;
			case 5:
				exibirMenuDeUsuarios(entrada, usuario, repositorioUsuario, conexao);
				break;
			case 6:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				FuncoesTela.limparTela();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				break;
			}
		}
	}

	private static void exibirMenuDeLancamentos(Scanner entrada, Lancamento lancamento, LancamentoRepositorio repositorio,
			Connection conexao) throws SQLException {
		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuDeLancamentos);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				lancamento = DataSource.capturaDados(entrada, lancamento);
				repositorio.inserir(conexao, lancamento);
				break;
			case 2:
				lancamento = DataSource.capturaDados(entrada, lancamento);
				repositorio.alterar(conexao, lancamento);
				break;
			case 3:
				lancamento = DataSource.capturaDados(entrada, lancamento);
				repositorio.excluir(conexao, lancamento);
				break;
			case 4:
				ArrayList<Lancamento> lancamentos = repositorio.listarTodos(conexao);
				FuncoesTela.imprimirLancamentos(lancamentos);
				break;
			case 5:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				entrada.nextLine();
				break;
			}
		}
	}

	private static void exibirMenuDeSenhas(Scanner entrada, Senha senha, SenhaRepositorio repositorio, Connection conexao)
			throws SQLException {
		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuDeSenhas);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				senha = DataSource.capturaDados(entrada, senha);
				repositorio.inserir(conexao, senha);
				break;
			case 2:
				senha = DataSource.capturaDados(entrada, senha);
				repositorio.alterar(conexao, senha);
				break;
			case 3:
				senha = DataSource.capturaDados(entrada, senha);
				repositorio.excluir(conexao, senha);
				break;
			case 4:
				ArrayList<Senha> senhas = repositorio.listarTodos(conexao);
				FuncoesTela.imprimirSenhas(senhas);
				break;
			case 5:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				entrada.nextLine();
				break;
			}
		}
	}
	
	private static void exibirMenuDeTags(Scanner entrada, Tag tag, TagRepositorio repositorio, Connection conexao)
			throws SQLException {
		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuDeTags);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				tag = DataSource.capturaDados(entrada, tag);
				repositorio.inserir(conexao, tag);
				break;
			case 2:
				tag = DataSource.capturaDados(entrada, tag);
				repositorio.alterar(conexao, tag);
				break;
			case 3:
				tag = DataSource.capturaDados(entrada, tag);
				repositorio.excluir(conexao, tag);
				break;
			case 4:
				ArrayList<Tag> tags = repositorio.listarTodos(conexao);
				FuncoesTela.imprimirTags(tags);
				break;
			case 5:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				entrada.nextLine();
				break;
			}
		}
	}
	
	private static void exibirMenuDeTipos(Scanner entrada, Tipo tipo, TipoRepositorio repositorio, Connection conexao)
			throws SQLException {
		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuDeTipos);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				tipo = DataSource.capturaDados(entrada, tipo);
				repositorio.inserir(conexao, tipo);
				break;
			case 2:
				tipo = DataSource.capturaDados(entrada, tipo);
				repositorio.alterar(conexao, tipo);
				break;
			case 3:
				tipo = DataSource.capturaDados(entrada, tipo);
				repositorio.excluir(conexao, tipo);
				break;
			case 4:
				ArrayList<Tipo> tipos = repositorio.listarTodos(conexao);
				FuncoesTela.imprimirTipos(tipos);
				break;
			case 5:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				entrada.nextLine();
				break;
			}
		}
	}
	
	private static void exibirMenuDeUsuarios(Scanner entrada, Usuario usuario, UsuarioRepositorio repositorio, Connection conexao)
			throws SQLException {
		boolean exibirMenu = true;
		while (exibirMenu) {
			FuncoesTela.limparTela();
			System.out.println(stringMenuDeUsuarios);
			System.out.print("Por favor informe a opção desejada: ");

			int opcao = Integer.valueOf(entrada.nextLine());

			switch (opcao) {
			case 1:
				usuario = DataSource.capturaDados(entrada, usuario);
				repositorio.inserir(conexao, usuario);
				break;
			case 2:
				usuario = DataSource.capturaDados(entrada, usuario);
				repositorio.alterar(conexao, usuario);
				break;
			case 3:
				usuario = DataSource.capturaDados(entrada, usuario);
				repositorio.excluir(conexao, usuario);
				break;
			case 4:
				ArrayList<Usuario> usuarios = repositorio.listarTodos(conexao);
				FuncoesTela.imprimirUsuarios(usuarios);
				break;
			case 5:
				System.out.print("Saindo. Precione enter para continuar!");
				entrada.nextLine();
				exibirMenu = false;
				break;
			default:
				System.out.print("Opção inválida! Precione enter para continuar!");
				entrada.nextLine();
				break;
			}
		}
	}
}
