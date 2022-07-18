package tppe.tp1.acesso;

import java.time.LocalDateTime;

public class Acesso {

	private String placa;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private String tipoAcesso;
	private Float valorAcesso;
	private Float valorContratante;

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

	public Float getValorAcesso() {
		return valorAcesso;
	}

	public Float getValorContratante() {
		return valorContratante;
	}

	public Boolean isMensalista(String tipoAcesso) {
		if (this.tipoAcesso == "Mensalista")
			return true;
		else
			return false;
	}

	public Boolean isEvento(String tipoAcesso) {
		if (tipoAcesso == "Evento")
			return true;
		else
			return false;
	}

}
