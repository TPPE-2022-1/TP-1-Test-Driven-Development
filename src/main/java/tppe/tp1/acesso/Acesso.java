package tppe.tp1.acesso;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import tppe.tp1.estacionamento.Estacionamento;

public class Acesso {

	private static final int _100 = 100;
	private static final int TREZE_HORAS_MINUTOS = 780;
	private String placa;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private String tipoAcesso;
	private Double valorAcesso;
	private Double valorContratante;

	Acesso(AcessoBuilder builder) {
		placa = builder.getPlaca();
		horaEntrada = builder.getHoraEntrada();
		horaSaida = builder.getHoraSaida();
		tipoAcesso = builder.getTipoAcesso();
		valorAcesso = builder.getValorAcesso();
		valorContratante = builder.getValorContratante();

	}

	public String getPlaca() {
		return placa;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public Double getValorAcesso() {
		return valorAcesso;
	}

	public Double getValorContratante() {
		return valorContratante;
	}

	public Boolean isMensalista() {
		if (this.tipoAcesso == "Mensalista")
			return true;
		else
			return false;
	}

	public Boolean isEvento() {
		if (tipoAcesso == "Evento")
			return true;
		else
			return false;
	}

	public void setValorContratante(Double d) {
		this.valorContratante = d;
	}

	public void setValorAcesso(Double valorAcesso) {
		this.valorAcesso = valorAcesso;
	}

	public Boolean isDiariaNoturna(Estacionamento e) {
		LocalDateTime entrada = getHoraEntrada();
		LocalDateTime saida = getHoraSaida();
		long minutosEstadia = ChronoUnit.MINUTES.between(entrada, saida);
		long minutosTotais = TREZE_HORAS_MINUTOS;
		long diff;

		if (entrada.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna())) {
			return true;
		} else if (entrada.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna())) {
			diff = ChronoUnit.MINUTES.between(e.getHorarioEntradaDiariaNoturna(), entrada);
			minutosTotais -= diff;
			minutosEstadia -= diff;
			return minutosTotais < minutosEstadia;
		} else if (e.getHorarioSaidaDiariaNoturna().isAfter(entrada.toLocalTime())) {
			diff = ChronoUnit.MINUTES.between(entrada.toLocalTime(), e.getHorarioEntradaDiariaNoturna());
			minutosTotais -= diff;
			minutosEstadia -= diff;
			return minutosTotais < minutosEstadia;
		} else if (saida.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna())
				|| e.getHorarioSaidaDiariaNoturna().isAfter(saida.toLocalTime())) {
			return true;
		} else
			return false;
	}

	public Integer getDiarias(Estacionamento e) {
		return new GetDiarias(horaEntrada, horaSaida).computar(e);
	}

	public Double calculoValorContratante(Double retornoContratante) {
		return this.valorAcesso * retornoContratante / _100;
	}
}
