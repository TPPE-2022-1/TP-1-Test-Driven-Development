package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaValorAcessoTest {
	Acesso acesso;
	Estacionamento estacionamento;
	
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
	void calculaValorAcessTest() throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca("abc1234");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T08:01"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-18T23:59"));
		
		acesso = a.build();
		assertEquals(91.00, estacionamento.calculaValorTotal(acesso));
	}

	@Test
	@Tag("TesteFuncional")
	void calculaValorAcessTestD() throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca("abc1234");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T09:00"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-18T10:00"));
		
		acesso = a.build();
		assertEquals(72.00, estacionamento.calculaValorTotal(acesso));
	}
}
