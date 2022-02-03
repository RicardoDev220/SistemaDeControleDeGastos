package fuctura.util;

import java.util.ArrayList;

import fuctura.model.Lancamento;
import fuctura.model.Senha;
import fuctura.model.Tag;
import fuctura.model.Tipo;
import fuctura.model.Usuario;

public class FuncoesTela {

	public static void imprimirLancamentos(ArrayList<Lancamento> lancamentos) {
		System.out.println("CÓDIGO|VALOR|DESCRIÇÃO");
		for (Lancamento lancamento : lancamentos) {
			System.out.print(" " + lancamento.getCodigo());
			System.out.print("    " + lancamento.getValor());
			System.out.println("  " + lancamento.getDescricao());
		}
	}

	public static void imprimirSenhas(ArrayList<Senha> senhas) {
		System.out.println("CÓDIGO|VALOR");
		for (Senha senha : senhas) {
			System.out.print(" " + senha.getCodigo());
			System.out.println("    " + senha.getValor());
		}
	}

	public static void imprimirTags(ArrayList<Tag> tags) {
		System.out.println("CÓDIGO|NOME");
		for (Tag tag : tags) {
			System.out.print(" " + tag.getCodigo());
			System.out.println("    " + tag.getNome());
		}
	}

	public static void imprimirTipos(ArrayList<Tipo> tipos) {
		System.out.println("CÓDIGO|NOME");
		for (Tipo tipo : tipos) {
			System.out.print(" " + tipo.getCodigo());
			System.out.println("    " + tipo.getNome());
		}
	}

	public static void imprimirUsuarios(ArrayList<Usuario> usuarios) {
		System.out.println("NOME   |   EMAIL  |IDADE");
		for (Usuario usuario : usuarios) {
			System.out.print(usuario.getNome());
			System.out.print("   " + usuario.getEmail());
			System.out.println("  " + usuario.getIdade());
		}
	}

	public static void limparTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
