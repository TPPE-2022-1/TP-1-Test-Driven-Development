package tppe.tp1.veiculo;

import java.time.LocalTime;

public class Veiculo {

	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private Boolean mensalista;
	private Boolean evento;

	Veiculo(VeiculoBuilder builder){
		placa = builder.getPlaca();
		horaEntrada = builder.getHoraEntrada();
		horaSaida = builder.getHoraSaida();
		mensalista = builder.getMensalista();
		evento = builder.getEvento();
		
	}
	public String getPlaca(){
		return placa;
	}
	public LocalTime gethoraEntrada() {
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
}
