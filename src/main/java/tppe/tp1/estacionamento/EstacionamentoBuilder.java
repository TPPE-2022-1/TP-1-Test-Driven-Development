package tppe.tp1.estacionamento;

import java.time.LocalTime;

import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaNegativaException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoHorariosAberturaEncerramentoInvalidos;
import tppe.tp1.estacionamento.exceptions.EstacionamentoIdInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorEventoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoZeroException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValoresNoturnosInvalidos;
import tppe.tp1.exceptions.DescricaoEmBrancoException;

public class EstacionamentoBuilder {

	private Integer id;
	private Double valorFracao;
	private Double descontoHoraCheia;
	private Double valorDiariaDiurna;
	private Double descontoDiariaNoturna;
	private LocalTime horarioEntradaDiariaNoturna;
	private LocalTime horarioSaidaDiariaNoturna;
	private Double valorMensalidade;
	private Double valorEvento;
	private LocalTime horarioAbertura;
	private LocalTime horarioEncerramento;
	private Integer capacidade;
	private Double retornoContratante;

	public Double getRetornoContratante() {
		return retornoContratante;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public LocalTime getHorarioEncerramento() {
		return horarioEncerramento;
	}

	public Double getValorEvento() {
		return valorEvento;
	}

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

	public Estacionamento build() throws EstacionamentoValoresNoturnosInvalidos,
			EstacionamentoHorariosAberturaEncerramentoInvalidos, DescricaoEmBrancoException {
		if (id == null) {
			throw new DescricaoEmBrancoException("Id n??o informado");
		}

		if (valorFracao == null) {
			throw new DescricaoEmBrancoException("Valor fra????o n??o informado");
		}

		if (descontoHoraCheia == null) {
			throw new DescricaoEmBrancoException("Valor desconto de hora cheia n??o informado");
		}

		if (valorDiariaDiurna == null) {
			throw new DescricaoEmBrancoException("Valor di??ria diurna n??o informado");
		}

		if (descontoDiariaNoturna == null) {
			throw new DescricaoEmBrancoException("Valor desconto di??ria noturna n??o informado");
		}

		if (horarioEntradaDiariaNoturna == null) {
			throw new DescricaoEmBrancoException("Valor hor??rio entrada noturna n??o informado");
		}

		if (horarioSaidaDiariaNoturna == null) {
			throw new DescricaoEmBrancoException("Valor hor??rio sa??da noturna n??o informado");
		}

		if (valorMensalidade == null) {
			throw new DescricaoEmBrancoException("Valor mensalidade n??o informado");
		}

		if (valorEvento == null) {
			throw new DescricaoEmBrancoException("Valor evento n??o informado");
		}

		if (horarioAbertura == null) {
			throw new DescricaoEmBrancoException("Hor??rio abertura n??o informado");
		}

		if (horarioEncerramento == null) {
			throw new DescricaoEmBrancoException("Hor??rio fechamento n??o informado");
		}

		if (capacidade == null) {
			throw new DescricaoEmBrancoException("Valor capacidade n??o informado");
		}

		if (retornoContratante == null) {
			throw new DescricaoEmBrancoException("Retorno contratante n??o informado");
		}

		/*
		 * Validar hor??rio de abertura e encerramento
		 * 
		 * O hor??rio de abertura deve ser anterior (menor) ao de encerramento, pois
		 * ambos acontecem no mesmo dia
		 */
		if (horarioAbertura.isAfter(horarioEncerramento)) {
			throw new EstacionamentoHorariosAberturaEncerramentoInvalidos(
					"Hor??rio de abertura deve ser anterior ao de encerramento");
		}

		/*
		 * Validar hor??rio de entrada e sa??da da di??ria noturna
		 * 
		 * O hor??rio de entrada deve ser maior (posterior) do que o de sa??da, pois se
		 * refere ao dia anterior
		 */
		if (horarioEntradaDiariaNoturna.isBefore(horarioSaidaDiariaNoturna)) {
			throw new EstacionamentoValoresNoturnosInvalidos(
					"Hor??rio de entrada deve posterior ao de sa??da, por acontecer no dia anterior");
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

	public void setValorDiariaDiurna(double valorDiariaDiurna)
			throws EstacionamentoValorDiariaDiurnaInvalidoZeroException,
			EstacionamentoValorDiariaDiurnaInvalidoNegativoException {
		if (Double.compare(valorDiariaDiurna, 0.00) == 0) {
			throw new EstacionamentoValorDiariaDiurnaInvalidoZeroException();
		}

		if (valorDiariaDiurna < 0.00) {
			throw new EstacionamentoValorDiariaDiurnaInvalidoNegativoException();
		}

		this.valorDiariaDiurna = valorDiariaDiurna;
	}

	public void setDescontoDiariaNoturna(double descontoDiariaNoturna)
			throws EstacionamentoValorDiariaNoturnaInvalidoNegativoException,
			EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception {
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

	public void setValorMensalidade(Double mensalidade) throws EstacionamentoValorMensalidadeInvalidoZeroException,
			EstacionamentoValorMensalidadeInvalidoNegativoException {
		if (mensalidade.compareTo(0.00) == 0) {
			throw new EstacionamentoValorMensalidadeInvalidoZeroException();
		}

		if (mensalidade < 0.00) {
			throw new EstacionamentoValorMensalidadeInvalidoNegativoException();
		}

		this.valorMensalidade = mensalidade;
	}

	public void setValorEvento(Double valorEvento) throws EstacionamentoValorEventoInvalidoNegativoException {
		if (valorEvento < 0.00) {
			throw new EstacionamentoValorEventoInvalidoNegativoException();
		}

		this.valorEvento = valorEvento;
	}

	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public void setHorarioEncerramento(LocalTime horarioEncerramento) {
		this.horarioEncerramento = horarioEncerramento;
	}

	public void setCapacidade(Integer capacidade)
			throws EstacionamentoCapacidadeInvalidaZeroException, EstacionamentoCapacidadeInvalidaNegativaException {
		if (capacidade.compareTo(0) == 0) {
			throw new EstacionamentoCapacidadeInvalidaZeroException();
		}

		if (capacidade < 0) {
			throw new EstacionamentoCapacidadeInvalidaNegativaException();
		}

		this.capacidade = capacidade;
	}

	public void setRetornoContratante(Double retornoContratante)
			throws EstacionamentoRetornoContratanteInvalidoZeroException,
			EstacionamentoRetornoContratanteInvalidoNegativoException {
		if (retornoContratante.compareTo(0.0) == 0) {
			throw new EstacionamentoRetornoContratanteInvalidoZeroException();
		}

		if (retornoContratante < 0) {
			throw new EstacionamentoRetornoContratanteInvalidoNegativoException();
		}

		this.retornoContratante = retornoContratante;
	}

}
