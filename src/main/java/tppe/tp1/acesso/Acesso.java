package tppe.tp1.acesso;

import java.time.LocalTime;
import java.util.function.BooleanSupplier;

public class Acesso {

	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
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

	public Boolean isMensalista(String tipoAcesso) {
		if (this.tipoAcesso == "Mensalista")
			return true;
		else
			return false;
	}

}
