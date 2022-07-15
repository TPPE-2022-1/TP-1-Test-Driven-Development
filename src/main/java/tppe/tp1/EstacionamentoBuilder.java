package tppe.tp1;

import java.time.LocalTime;

public class EstacionamentoBuilder {

	int id;
	double valorFracao;
	private double descontoHoraCheia;
	private double valorDiariaDiurna;
	private double descontoDiariaNoturna;
	private LocalTime horarioEntradaDiariaNoturna;

	public LocalTime getHorarioEntradaDiariaNoturna() {
		return horarioEntradaDiariaNoturna;
	}

	public double getDescontoDiariaNoturna() {
		return descontoDiariaNoturna;
	}

	public double getValorDiariaDiurna() {
		return valorDiariaDiurna;
	}

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

	public void setValorDiariaDiurna(double valorDiariaDiurna) throws EstacionamentoValorDiariaDiurnaInvalidoZeroException, EstacionamentoValorDiariaDiurnaInvalidoNegativoException {
		if (Double.compare(valorDiariaDiurna, 0.00) == 0) {
			throw new EstacionamentoValorDiariaDiurnaInvalidoZeroException();
		}
		
		if (valorDiariaDiurna < 0.00) {
			throw new EstacionamentoValorDiariaDiurnaInvalidoNegativoException();
		}
		
		this.valorDiariaDiurna = valorDiariaDiurna;
	}

	public void setDescontoDiariaNoturna(double descontoDiariaNoturna) throws EstacionamentoValorDiariaNoturnaInvalidoNegativoException, EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception {
		if (descontoDiariaNoturna < 0.0) {
			throw new EstacionamentoValorDiariaNoturnaInvalidoNegativoException();
		}
		
		if (descontoDiariaNoturna > 100.0) {
			throw new EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception();
		}
		
		this.descontoDiariaNoturna = descontoDiariaNoturna;
	}

	public void setHorarioEntradaDiariaNoturna(LocalTime horarioEntradaDiariaNoturna) {
		this.horarioEntradaDiariaNoturna = horarioEntradaDiariaNoturna;
	}

}
