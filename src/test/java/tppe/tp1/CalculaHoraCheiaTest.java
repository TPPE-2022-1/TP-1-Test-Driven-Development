package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaHoraCheiaTest {
	
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
	@Tag("Teste Funcional")
	void testCalculaHoraCheia() {
		assertEquals(72.00, estacionamento.calculaHoraCheia(LocalTime.of(12, 0), LocalTime.of(13, 0)), 0.1);
	}
	

	
	@Test
	@Tag("Teste Funcional")
	void testCalculaHoraCheiaD() {
		assertEquals(144.00, estacionamento.calculaHoraCheia(LocalTime.of(12, 0), LocalTime.of(14, 0)), 0.1);
	}
}
