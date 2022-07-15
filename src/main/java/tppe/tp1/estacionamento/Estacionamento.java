package tppe.tp1.estacionamento;

public class Estacionamento {
	private int id;
	private double valorFracao;
	
	Estacionamento(EstacionamentoBuilder builder) {
		this.id = builder.id;
		this.valorFracao = builder.valorFracao;
	}

	public Integer getId() {
		return this.id;
	}

	public Double getValorFracao() {
		return this.valorFracao;
	}
}
