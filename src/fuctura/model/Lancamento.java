package fuctura.model;

public class Lancamento {
	private int codigo;
	private double valor;
	private String descricao;

	public Lancamento() {
		super();
	}

	public Lancamento(int codigo, double valor, String descricao) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}