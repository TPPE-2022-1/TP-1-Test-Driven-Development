package tppe.tp1.estacionamento;

public class Estacionamento {
	private Integer id;
	private Double valorFracao;
	
	Estacionamento(EstacionamentoBuilder builder) {
		this.id = builder.getId();
		this.valorFracao = builder.getValorFracao();
	}

	public Integer getId() {
		return this.id;
	}

	public Double getValorFracao() {
		return this.valorFracao;
	}
}
