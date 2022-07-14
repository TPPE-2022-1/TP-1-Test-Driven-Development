package tppe.tp1;

public class EstacionamentoBuilder {

	int id;
	double valorFracao;
	private double descontoHoraCheia;

	public double getDescontoHoraCheia() {
		return descontoHoraCheia;
	}

	public int getId() {
		return id;
	}

	public double getValorFracao() {
		return valorFracao;
	}

	public void setId(int id) throws EstacionamentoIdInvalidoException {
		if (id < 0) {
			throw new EstacionamentoIdInvalidoException();
		}
		this.id = id;
	}

	public Estacionamento build() throws EstacionamentoIdInvalidoException, EstacionamentoValorFracaoInvalidoException {
		if (id < 0) {
			throw new EstacionamentoIdInvalidoException();
		}
		if (Double.compare(valorFracao, 0.00) == 0) {
			throw new EstacionamentoValorFracaoInvalidoException();
		}
		return new Estacionamento(this);
	}

	public void setValorFracao(double valorFracao) throws EstacionamentoValorFracaoInvalidoException {
		Double.compare(valorFracao, 0.00);
		if (Double.compare(valorFracao, 0.00) == 0) {
			throw new EstacionamentoValorFracaoInvalidoZeroException();
		}
		
		if (valorFracao < 0.00) {
			throw new EstacionamentoValorFracaoInvalidoNegativoException();
		}
		
		this.valorFracao = valorFracao;
	}

	public void setDescontoHoraCheia(double descontoHoraCheia) throws EstacionamentoValorHoraCheiaInvalido {
		if (descontoHoraCheia < 0.0) {
			throw new EstacionamentoValorHoraCheiaInvalidoNegativoException();
		}
		
		if (descontoHoraCheia > 100.0) {
			throw new EstacionamentoValorHoraCheiaInvalidoMaior100Exception();
		}
		this.descontoHoraCheia = descontoHoraCheia;
	}

}
