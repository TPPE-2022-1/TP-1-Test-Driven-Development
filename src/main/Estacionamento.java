package main;

public class Estacionamento {
	private int id;
	
	Estacionamento(EstacionamentoBuilder builder) {
		this.id = builder.id;
	}

	public Integer getId() {
		return this.id;
	}
}
