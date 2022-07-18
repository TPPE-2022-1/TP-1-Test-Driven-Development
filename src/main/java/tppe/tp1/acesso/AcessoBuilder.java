package tppe.tp1.acesso;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import tppe.tp1.acesso.exceptions.AcessoEventoInvalidoException;
import tppe.tp1.acesso.exceptions.AcessoEventoVazioException;
import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;
import tppe.tp1.acesso.exceptions.AcessoPlacaVazioException;
import tppe.tp1.exceptions.DescricaoEmBrancoException;
import tppe.tp1.estacionamento.Estacionamento;

public class AcessoBuilder {

	private String placa;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private String tipoAcesso;
	private Double valorAcesso;
	private Double valorContratante;

	public Acesso build() throws DescricaoEmBrancoException {
		if (horaEntrada == null) {
			throw new DescricaoEmBrancoException("Hora de entrada não pode ser nula");
		}
		if (horaSaida == null) {
			throw new DescricaoEmBrancoException("Hora de saída não pode ser nula");
		}
//		if (valorAcesso == null) {
//			throw new DescricaoEmBrancoException("Valor do acesso não pode ser nulo");
//		}
//		if (valorContratante == null) {
//			throw new DescricaoEmBrancoException("Valor do contratante não pode ser nulo");
//		}

		return new Acesso(this);
	}

	// GET
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

	public Boolean isDiariaDiurna(Estacionamento e) {
		LocalDateTime entrada = getHoraEntrada();
		LocalDateTime saida = getHoraSaida();
		LocalDateTime horarioEntradaNoturna = LocalDateTime.of(entrada.toLocalDate(),
				e.getHorarioEntradaDiariaNoturna());
		// não pode virar o dia
		LocalDateTime horarioSaidaNoturna = LocalDateTime.of(entrada.toLocalDate(), e.getHorarioSaidaDiariaNoturna());

		Duration duration = Duration.between(entrada, saida);

		return (duration.toHours() >= 9) && entrada.isAfter(horarioSaidaNoturna)
				&& saida.isBefore(horarioEntradaNoturna);

//		LocalDateTime entrada = getHoraEntrada();
//		LocalDateTime saida = getHoraSaida();
//		Boolean entrouNoite = false;
//		Boolean saiuNoite = false;
//		if(saida.compareTo(entrada) < 0) {
//			if(saida.toSecondOfDay() - e.getHorarioSaidaDiariaNoturna().toSecondOfDay()
//					>= LocalTime.of(8, 46).toSecondOfDay())
//				return true; // ficou toda a noite mais 8:46 horas de dia
//			if(e.getHorarioEntradaDiariaNoturna().toSecondOfDay() - entrada.toSecondOfDay()
//					>= LocalTime.of(8, 46).toSecondOfDay())
//				return true; // ficou mais de 8:46 horas no dia e virou a noite
//		}
//		if(getHoraEntrada().compareTo(e.getHorarioEntradaDiariaNoturna()) > 0 ||
//		   getHoraEntrada().compareTo(e.getHorarioSaidaDiariaNoturna()) < 0) {
//			entrada = e.getHorarioSaidaDiariaNoturna();
//			entrouNoite = true;
//		}
//		if(getHoraSaida().compareTo(e.getHorarioSaidaDiariaNoturna()) < 0||
//		   getHoraSaida().compareTo(e.getHorarioEntradaDiariaNoturna()) > 0) {
//			saida = e.getHorarioEntradaDiariaNoturna();
//			saiuNoite = true;
//		}
//		if(entrouNoite && saiuNoite)
//			return false;  // ficou somente o periodo noturno
//		if(saida.toSecondOfDay() - entrada.toSecondOfDay() < LocalTime.of(8, 46).toSecondOfDay())
//				return false; // nao completou 8:46 horas dirunas
//		return true; // completou 9 hroas diurnas
	}

	public Boolean isDiariaNoturna(Estacionamento e) {
		LocalDateTime entrada = getHoraEntrada();
		LocalDateTime saida = getHoraSaida();

		LocalDateTime horarioEntradaNoturna = LocalDateTime.of(entrada.toLocalDate(),
				e.getHorarioEntradaDiariaNoturna());
		LocalDateTime horarioSaidaNoturna = LocalDateTime.of(entrada.toLocalDate().plusDays(1), e.getHorarioSaidaDiariaNoturna());

		Period estadia = Period.between(entrada.toLocalDate(), saida.toLocalDate());

		return (estadia.getDays() <= 1) && entrada.isAfter(horarioEntradaNoturna) && saida.isBefore(horarioSaidaNoturna);

//		LocalDateTime entrada = getHoraEntrada();
//		LocalDateTime saida = getHoraSaida();
//		if(saida.compareTo(entrada) > 0) {
//			if(entrada.compareTo(e.getHorarioSaidaDiariaNoturna()) < 0)
//				return true; // entrou ainda no periodo noturno
//			if(isDiariaDiurna(e))
//				return false; // horario já pago na diaria noturna
//			if(saida.compareTo(e.getHorarioEntradaDiariaNoturna()) > 0)
//				return true; // ficou a noite
//			return false;
//		}
//		return true; // virou o dia
	}
	// Fim Get

	// SET
	public void setValorContratante(Double d) {
		this.valorContratante = d;
	}

	public void setValorAcesso(Double valorAcesso) {
		this.valorAcesso = valorAcesso;
	}

	public void setTipoAcesso(String tipoAcesso) throws AcessoEventoInvalidoException, AcessoEventoVazioException {
		if (tipoAcesso.trim().equalsIgnoreCase("Mensalista"))
			this.tipoAcesso = "Mensalista";
		else if (tipoAcesso.trim().equalsIgnoreCase("Evento"))
			this.tipoAcesso = "Evento";
		else if (tipoAcesso != null && tipoAcesso.trim().length() > 0)
			throw new AcessoEventoInvalidoException();
		else
			throw new AcessoEventoVazioException();
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public void setPlaca(String placa) throws AcessoPlacaInvalidaException, AcessoPlacaVazioException {
		if (placa.trim().isEmpty()) {
			throw new AcessoPlacaVazioException();
		}
		if (placa.trim().length() != 7) {
			throw new AcessoPlacaInvalidaException();
		}
		this.placa = placa;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	// FIM SET
}
