package tppe.tp1.veiculo;

import java.time.LocalTime;

public class VeiculoBuilder {
	
	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private Boolean mensalista;
	private Boolean evento;
	
	// SET
	public void setPlaca(String placa){
		this.placa = placa;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}
	public void setMensalista(Boolean mensalista) {
		this.mensalista = mensalista;
	}
	public void setEvento(Boolean evento) {
		this.evento = evento;
	}
	// FIM SET
	
	// GET
	public String getPlaca(){
		return placa;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public LocalTime getHoraSaida() {
		return horaSaida;
	}
	public Boolean getMensalista() {
		return mensalista;
	}
	public Boolean getEvento() {
		return evento;
	}
	// FIM GET
	
	
	public Veiculo build(){
		return new Veiculo(this);
	}
	
}
