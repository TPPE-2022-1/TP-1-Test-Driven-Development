package tppe.tp1.acesso;

import java.time.LocalTime;

import tppe.tp1.acesso.exceptions.AcessoEventoInvalidoException;
import tppe.tp1.acesso.exceptions.AcessoEventoVazioException;
import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;
import tppe.tp1.acesso.exceptions.AcessoPlacaVazioException;


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
	// Fim Get
	
	//	SET
	public void setValorContratante(Float valorContratante) {
		this.valorContratante = valorContratante;
	}

	public void setValorAcesso(Float valorAcesso) {
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
