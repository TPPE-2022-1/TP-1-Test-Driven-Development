package tppe.tp1.acesso;

import java.time.LocalTime;

import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;
import tppe.tp1.acesso.exceptions.AcessoPlacaVazioException;
import tppe.tp1.estacionamento.EstacionamentoBuilder;


public class AcessoBuilder {
	
	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private String tipoAcesso;
	private Float valorAcesso;
	private Float valorContratante;	
	
	public Acesso build(){
		return new Acesso(this);
	}

	// GET
	public String getPlaca() {
		return placa;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public Float getValorAcesso() {
		return valorAcesso;
	}

	public Float getValorContratante() {
		return valorContratante;
	}

	public Boolean isDiariaDiurna(EstacionamentoBuilder e) {
		LocalTime entrada = getHoraEntrada();
		LocalTime saida = getHoraSaida();
		Boolean entrouNoite = false;
		Boolean saiuNoite = false;
		if(saida.compareTo(entrada) < 0) {
			if(saida.toSecondOfDay() - e.getHorarioSaidaDiariaNoturna().toSecondOfDay()
					>= LocalTime.of(9, 0).toSecondOfDay())
				return true; // ficou toda a noite mais 9 horas de dia
			if(e.getHorarioEntradaDiariaNoturna().toSecondOfDay() - entrada.toSecondOfDay()
					>= LocalTime.of(9, 0).toSecondOfDay())
				return true; // ficou mais de 9 horas no dia e virou a noite
		}
		if(getHoraEntrada().compareTo(e.getHorarioEntradaDiariaNoturna()) > 0 ||
		   getHoraEntrada().compareTo(e.getHorarioSaidaDiariaNoturna()) < 0) {
			entrada = e.getHorarioSaidaDiariaNoturna();
			entrouNoite = true;
		}
		if(getHoraSaida().compareTo(e.getHorarioSaidaDiariaNoturna()) < 0||
		   getHoraSaida().compareTo(e.getHorarioEntradaDiariaNoturna()) > 0) {
			saida = e.getHorarioEntradaDiariaNoturna();
			saiuNoite = true;
		}
		if(entrouNoite && saiuNoite)
			return false;  // ficou somente o periodo noturno
		if(saida.toSecondOfDay() - entrada.toSecondOfDay() < LocalTime.of(9, 0).toSecondOfDay())
				return false; // nao completou 9 horas dirunas
		return true; // completou 9 hroas diurnas
	}
	// Fim Get
	
	//	SET
	public void setValorContratante(Float valorContratante) {
		this.valorContratante = valorContratante;
	}

	public void setValorAcesso(Float valorAcesso) {
		this.valorAcesso = valorAcesso;
	}
	
	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public void setPlaca(String placa) throws AcessoPlacaInvalidaException, AcessoPlacaVazioException {
		if(placa.trim().isEmpty()) {
			throw new AcessoPlacaVazioException();
		}
		if(placa.trim().length() != 7) {
			throw new AcessoPlacaInvalidaException();
		}
		this.placa = placa;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	//	FIM SET
}
