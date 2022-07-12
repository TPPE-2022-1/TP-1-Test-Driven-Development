package main;

public class EstacionamentoBuilder {

	int id;

	public void setId(int id) {
		this.id = id;
	}

	public Estacionamento build() {
		return new Estacionamento(this);
	}

}
