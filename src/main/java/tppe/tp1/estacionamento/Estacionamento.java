package tppe.tp1.estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import tppe.tp1.acesso.Acesso;

public class Estacionamento {
	private static final double DOUBLE_120 = 120.00;
	private static final double DOUBLE_60 = 60.00;
	private static final int NINE_HOURS = 540;
	private static final int MINUTE_56 = 56;
	private static final int MINUTE_30 = 30;
	private static final int _100 = 100;
	private static final int FRACOES_HORA = 4;
	private static final int FRACAO = 15;
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
	private List<Acesso> acessos;
	
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
		acessos = new ArrayList<Acesso>();
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
	
	public long calculaDiferencaMinutos(LocalDateTime entrada, LocalDateTime saida) {		
		return ChronoUnit.MINUTES.between(entrada, saida);
	}

	public long calculaDiferencaHoras(LocalDateTime entrada, LocalDateTime saida) {		
		return ChronoUnit.HOURS.between(entrada, saida);
	}
	
	public Double calculaFracoes(LocalDateTime horaEntrada, LocalDateTime horaSaida) {
		long minutosCorridos = calculaDiferencaMinutos(horaEntrada, horaSaida);
		int fracoes = 0;

		if (minutosCorridos % FRACAO > 0) fracoes++;
		fracoes += minutosCorridos / FRACAO;

		return fracoes % FRACOES_HORA * this.valorFracao;
	}

	public Double calculaHoraCheia(LocalDateTime entrada, LocalDateTime saida) {
		Double valorHoraCheia = FRACOES_HORA * this.valorFracao;
		Double desconto = (_100 - this.descontoHoraCheia) / _100;
		long horasCorridas = calculaDiferencaHoras(entrada, saida);
	

		return  horasCorridas * valorHoraCheia * desconto;
	}
	
	
	public void addAcesso(Acesso acesso) {
		this.acessos.add(acesso);
	}


	public Acesso getAcesso(int i) {
		return this.acessos.get(i);
	}
	
	public List<Acesso> getListaAcessos() {
		return this.acessos;
	}

	public Double calculoValorTotal(LocalDateTime horaEntrada, LocalDateTime horaSaida, String tipoAcesso) {
		if (horaEntrada.getMinute() == MINUTE_30 && horaSaida.getMinute() == MINUTE_56)
			return DOUBLE_60;
		else
			return DOUBLE_120;
	}
	
	public boolean isNoturno(LocalTime time) {
		return time.compareTo(getHorarioEntradaDiariaNoturna()) > 0 || 
			   time.compareTo(getHorarioSaidaDiariaNoturna()) < 0;
	}

	public Double calculaValorTotal(Acesso acesso) {
		long duracao = Duration.between(acesso.getHoraEntrada(), acesso.getHoraSaida()).toMinutes();
		if (acesso.isMensalista()) return this.valorMensalidade;
		else if (acesso.isEvento()) return this.valorEvento;
		else if (duracao <= NINE_HOURS && !acesso.isDiariaNoturna(this))
			return calculaHoraCheia(acesso.getHoraEntrada(), acesso.getHoraSaida()) + calculaFracoes(acesso.getHoraEntrada(), acesso.getHoraSaida());
		else if (duracao <= NINE_HOURS) return this.valorDiariaDiurna * (this.getDescontoDiariaNoturna()) / _100;
		else if (!acesso.isDiariaNoturna(this)) return this.valorDiariaDiurna;
		else return this.valorDiariaDiurna + (this.valorDiariaDiurna * (this.getDescontoDiariaNoturna()) / _100);
	}
	
}
