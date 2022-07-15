package tppe.tp1.estacionamento;

import java.time.LocalTime;

import tppe.tp1.estacionamento.exceptions.EstacionamentoIdInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoZeroException;

public class EstacionamentoBuilder {

	int id;
	double valorFracao;
	private double descontoHoraCheia;
	private double valorDiariaDiurna;
	private double descontoDiariaNoturna;
	private LocalTime horarioEntradaDiariaNoturna;
	private LocalTime horarioSaidaDiariaNoturna;
	private Double valorMensalidade;

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public LocalTime getHorarioSaidaDiariaNoturna() {
		return horarioSaidaDiariaNoturna;
	}

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

	public void setDescontoHoraCheia(double descontoHoraCheia) throws EstacionamentoValorHoraCheiaInvalidoException {
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

	public void setHorarioSaidaDiariaNoturna(LocalTime horarioSaidaDiariaNoturna) {
		this.horarioSaidaDiariaNoturna = horarioSaidaDiariaNoturna;
	}

	public void setValorMensalidade(Double mensalidade) throws EstacionamentoValorMensalidadeInvalidoZeroException, EstacionamentoValorMensalidadeInvalidoNegativoException {
		if (mensalidade.compareTo(0.00) == 0) {
			throw new EstacionamentoValorMensalidadeInvalidoZeroException();
		}
		
		if (mensalidade < 0.00) {
			throw new EstacionamentoValorMensalidadeInvalidoNegativoException();
		}
		
		this.valorMensalidade = mensalidade;
	}

}
