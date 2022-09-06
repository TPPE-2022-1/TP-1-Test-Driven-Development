package tppe.tp1.acesso;

import java.time.LocalDateTime;
import java.time.LocalTime;

import tppe.tp1.estacionamento.Estacionamento;

public class GetDiarias {
	private final int TAM_DIARIA = 32400;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private LocalTime entradaTime;
	private LocalTime saidaTime;
	private boolean entrouNoite;
	private boolean saiuNoite;

	GetDiarias(LocalDateTime entrada, LocalDateTime saida) {
		this.entrada = entrada;
		this.saida = saida;
		this.entradaTime = entrada.toLocalTime();
		this.saidaTime = saida.toLocalTime();
		this.entrouNoite = false;
		this.saiuNoite = false;
	}

	public Integer computar(Estacionamento e) {
		if (saiuMesmoDia())
			return hasDiaria(e);
		else
			return calcDiarias(e);
	}

	private boolean saiuMesmoDia() {
		return entrada.toLocalDate().equals(saida.toLocalDate());
	}

	private Integer hasDiaria(Estacionamento e) {
		if (e.isNoturno(entradaTime))
			entrouNoite = true;
		if (e.isNoturno(saidaTime))
			saiuNoite = true;
		if (entrouNoite && saiuNoite)
			return 0;
		if (saidaTime.toSecondOfDay() - entradaTime.toSecondOfDay() >= TAM_DIARIA)
			return 1;
		return 0;
	}

	private Integer calcDiarias(Estacionamento e) {
		int diarias = 0;
		int nDias = saida.getDayOfYear() - entrada.getDayOfYear();

		for (int i = 0; i <= nDias; i++) {
			if (i == 0) {
				if (e.getHorarioEntradaDiariaNoturna().toSecondOfDay() - entradaTime.toSecondOfDay() >= TAM_DIARIA)
					diarias++;
			} else if (i == nDias) {
				if (saidaTime.toSecondOfDay() - e.getHorarioSaidaDiariaNoturna().toSecondOfDay() >= TAM_DIARIA)
					diarias++;
			} else {
				diarias++;
			}
		}

		return diarias;
	}

}