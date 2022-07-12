package main;

public class EstacionamentoBuilder {

	int id;

	public void setId(int id) throws EstacionamentoIdInvalidoException {
		if (id < 0) {
			throw new EstacionamentoIdInvalidoException();
		}
		this.id = id;
	}

	public Estacionamento build() throws EstacionamentoIdInvalidoException {
		if (id < 0) {
			throw new EstacionamentoIdInvalidoException();
		}
		return new Estacionamento(this);
	}

}
