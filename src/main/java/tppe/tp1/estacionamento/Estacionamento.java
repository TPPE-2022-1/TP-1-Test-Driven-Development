package tppe.tp1.estacionamento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Estacionamento {
	private Integer id;
	private Double valorFracao;
	private Double descontoHoraCheia;
	private Double valorDiariaDiurna;
	private Double descontoDiariaNoturna;
	private LocalTime horarioEntradaDiariaNoturna;
	private LocalTime horarioSaidaDiariaNoturna;
	private Double valorMensalidade;
	private Double valorEvento;
	private LocalTime horarioAbertura;
	private LocalTime horarioEncerramento;
	private Integer capacidade;
	private Double retornoContratante;
	
	Estacionamento(EstacionamentoBuilder builder) {
		id = builder.getId();
		valorFracao = builder.getValorFracao();
		descontoHoraCheia = builder.getDescontoHoraCheia();
		valorDiariaDiurna = builder.getValorDiariaDiurna();
		descontoDiariaNoturna = builder.getDescontoDiariaNoturna();
		horarioEntradaDiariaNoturna = builder.getHorarioEntradaDiariaNoturna();
		horarioSaidaDiariaNoturna = builder.getHorarioSaidaDiariaNoturna();
		valorMensalidade = builder.getValorMensalidade();
		valorEvento = builder.getValorEvento();
		horarioAbertura = builder.getHorarioAbertura();
		horarioEncerramento = builder.getHorarioEncerramento();
		capacidade = builder.getCapacidade();
		retornoContratante = builder.getRetornoContratante();
	}

	public Integer getId() {
		return id;
	}

	public Double getValorFracao() {
		return valorFracao;
	}

	public Double getDescontoHoraCheia() {
		return descontoHoraCheia;
	}

	public Double getValorDiariaDiurna() {
		return valorDiariaDiurna;
	}

	public Double getDescontoDiariaNoturna() {
		return descontoDiariaNoturna;
	}

	public LocalTime getHorarioEntradaDiariaNoturna() {
		return horarioEntradaDiariaNoturna;
	}

	public LocalTime getHorarioSaidaDiariaNoturna() {
		return horarioSaidaDiariaNoturna;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public Double getValorEvento() {
		return valorEvento;
	}

	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public LocalTime getHorarioEncerramento() {
		return horarioEncerramento;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public Double getRetornoContratante() {
		return retornoContratante;
	}
	
	public long calculaDiferencaMinutos(LocalTime entrada, LocalTime saida) {		
		return ChronoUnit.MINUTES.between(entrada, saida);
	}

	public long calculaDiferencaHoras(LocalTime entrada, LocalTime saida) {		
		return ChronoUnit.HOURS.between(entrada, saida);
	}
	
	public Double calculaFracoes(LocalTime horaEntrada, LocalTime horaSaida) {
		long minutosCorridos = calculaDiferencaMinutos(horaEntrada, horaSaida);
		int fracoes = 0;

		if (minutosCorridos < 15) return 0.00;
		if (minutosCorridos % 15 > 0) fracoes++;
		fracoes += minutosCorridos / 15;

		return fracoes % 4 * this.valorFracao;
	}

	public Double calculaHoraCheia(LocalTime entrada, LocalTime saida) {
		Double valorHoraCheia = 4 * this.valorFracao;
		Double desconto = (100 - this.descontoHoraCheia) / 100;

		return  valorHoraCheia * desconto;
	}
}
