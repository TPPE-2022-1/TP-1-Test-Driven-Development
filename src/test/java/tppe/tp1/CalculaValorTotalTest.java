package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.acesso.exceptions.AcessoEventoInvalidoException;
import tppe.tp1.acesso.exceptions.AcessoEventoVazioException;
import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;
import tppe.tp1.acesso.exceptions.AcessoPlacaVazioException;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaValorTotalTest {
	
	private Estacionamento estacionamento;
	
	@BeforeEach
	void setup() throws Exception {
		EstacionamentoBuilder e = new EstacionamentoBuilder();
		e.setId(0);
		e.setValorFracao(20.00);
		e.setDescontoHoraCheia(10.00);
		e.setValorDiariaDiurna(70.00);
		e.setDescontoDiariaNoturna(30.00);
		e.setHorarioEntradaDiariaNoturna(LocalTime.of(21, 0));
		e.setHorarioSaidaDiariaNoturna(LocalTime.of(7, 0));
		e.setValorMensalidade(455.00);
		e.setValorEvento(60.00);
		e.setHorarioAbertura(LocalTime.of(0, 0));
		e.setHorarioEncerramento(LocalTime.of(23, 59));
		e.setCapacidade(120);
		e.setRetornoContratante(60.00);
		this.estacionamento = e.build();
	}
	
	@Test
	@Tag("TesteFuncional")
	void testCalculoValorTotal() throws Exception {
		
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		acessoBuilder.setPlaca("GHJ7653");
		acessoBuilder.setHoraEntrada(LocalDateTime.parse("2022-07-17T08:00"));
		acessoBuilder.setHoraSaida(LocalDateTime.parse("2022-07-17T18:00"));
		acessoBuilder.setTipoAcesso("Mensalista");
		acessoBuilder.setValorAcesso(estacionamento.calculoValorTotal(acessoBuilder.getHoraEntrada(),
																	  acessoBuilder.getHoraSaida(),
																	  acessoBuilder.getTipoAcesso()));
		assertEquals(120.00, acessoBuilder.getValorAcesso(),0.1f);
		
	}

}
