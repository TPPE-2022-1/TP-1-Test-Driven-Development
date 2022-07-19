package tppe.tp1.acesso;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalTime;
import java.time.Period;

import tppe.tp1.estacionamento.Estacionamento;

public class Acesso {

	private String placa;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private String tipoAcesso;
	private Double valorAcesso;
	private Double valorContratante;

	Acesso(AcessoBuilder builder){
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
		long minutosTotais = 780;
		long diff;
		
		if (entrada.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna())) {
			return true;
		} else if (entrada.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna())) {
			 diff = ChronoUnit.MINUTES.between(e.getHorarioEntradaDiariaNoturna(), entrada);
			 minutosTotais -= diff;
			 minutosEstadia -= diff;
			 return minutosTotais < minutosEstadia;
		} else if (e.getHorarioSaidaDiariaNoturna().isAfter(entrada.toLocalTime()))  {
			 diff = ChronoUnit.MINUTES.between(entrada.toLocalTime(), e.getHorarioEntradaDiariaNoturna());
			 minutosTotais -= diff;
			 minutosEstadia -= diff;
			 return minutosTotais < minutosEstadia;
		} else if (saida.toLocalTime().isAfter(e.getHorarioEntradaDiariaNoturna()) || e.getHorarioSaidaDiariaNoturna().isAfter(saida.toLocalTime())) {
			return true;
		} else
			return false;
 	}

	public Integer getDiarias(Estacionamento e) {
		LocalDateTime entrada = getHoraEntrada();
		LocalDateTime saida = getHoraSaida();
		LocalTime entradaTime = getHoraEntrada().toLocalTime();
		LocalTime saidaTime = getHoraSaida().toLocalTime();
		boolean entrouNoite = false, saiuNoite = false;
		if(entrada.toLocalDate().equals(saida.toLocalDate())) {
			if(e.isNoturno(entradaTime)) {
				entradaTime = e.getHorarioSaidaDiariaNoturna();
				entrouNoite = true;
			}
			if(e.isNoturno(saidaTime)) {
				saidaTime = e.getHorarioEntradaDiariaNoturna();
				saiuNoite = true;
			}
			if(entrouNoite && saiuNoite)
				return 0;
			if(saidaTime.toSecondOfDay() - entradaTime.toSecondOfDay() >= LocalTime.of(9, 0).toSecondOfDay())
				return 1;
			return 0;
		}
		int diarias = 0;
		int nDias = saida.getDayOfYear() - entrada.getDayOfYear();
		System.out.println(nDias);
		for(int i = 0; i <= nDias; i++) {
			if(i==0){
				if (e.getHorarioEntradaDiariaNoturna().toSecondOfDay() - entradaTime.toSecondOfDay() 
					>= LocalTime.of(9, 0).toSecondOfDay())
					diarias++;
			}
			else if(i==nDias) {
				if (saidaTime.toSecondOfDay() - e.getHorarioSaidaDiariaNoturna().toSecondOfDay()
					>= LocalTime.of(9, 0).toSecondOfDay())
					diarias++;
			} else {
				diarias++;
			}
		}
		return diarias;
	}

	public Double calculoValorContratante(Double valorAcesso) {
		if (valorAcesso > 40) return 273.00;
		return 24.00;
	}
}
