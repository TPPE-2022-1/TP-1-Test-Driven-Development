package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaFracoesTest {
	
	private Estacionamento estacionamento;
	
	@BeforeEach
	void setup() throws Exception {
		EstacionamentoBuilder e = new EstacionamentoBuilder();
		e.setId(0);
		e.setValorFracao(30f);
		e.setDescontoHoraCheia(15f);
		e.setValorDiariaDiurna(120f);
		e.setDescontoDiariaNoturna(45f);
		e.setHorarioEntradaDiariaNoturna(LocalTime.of(19, 0));
		e.setHorarioSaidaDiariaNoturna(LocalTime.of(8, 0));
		e.setValorMensalidade(600.00);
		e.setValorEvento(50.00);
		e.setHorarioAbertura(LocalTime.of(6, 0));
		e.setHorarioEncerramento(LocalTime.of(22, 0));
		e.setCapacidade(300);
		e.setRetornoContratante(50.00);
		this.estacionamento = e.build();
	}

	@Test
	@Tag("TesteFuncional")
	void testacalculoFracao() throws Exception {
		AcessoBuilder a = new AcessoBuilder();

		a.setPlaca("JGM4711");
		a.setHoraEntrada(LocalTime.of(12, 0));
		a.setHoraSaida(LocalTime.of(12, 15));

		assertEquals(30f, estacionamento.calculaFracoes(a.getHoraEntrada(), a.getHoraSaida()));
	}
	
	@Test
	@Tag("TesteFuncional")
	void testacalculoFracaoD() throws Exception {
		AcessoBuilder a = new AcessoBuilder();

		a.setPlaca("JFM0131");
		a.setHoraEntrada(LocalTime.of(12, 0));
		a.setHoraSaida(LocalTime.of(12, 30));

		assertEquals(60f, estacionamento.calculaFracoes(a.getHoraEntrada(), a.getHoraSaida()));
	}

}
