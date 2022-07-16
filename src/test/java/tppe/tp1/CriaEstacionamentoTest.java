package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CriaEstacionamentoTest {
	@Test
	@Tag("TesteFuncional")
	void testCriaestacionamento0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Estacionamento estacionamento = assertDoesNotThrow(() -> {
			return estacionamentoBuilder.build();
		});

		assertEquals(id, estacionamento.getId());
		assertEquals(valorFracao, estacionamento.getValorFracao());
		assertEquals(descontoHoraCheia, estacionamento.getDescontoHoraCheia());
		assertEquals(valorDiariaDiurna, estacionamento.getValorDiariaDiurna());
		assertEquals(descontoDiariaNoturna, estacionamento.getDescontoDiariaNoturna());
		assertEquals(entradaDiariaNoturna, estacionamento.getHorarioEntradaDiariaNoturna());
		assertEquals(saidaDiariaNoturna, estacionamento.getHorarioSaidaDiariaNoturna());
		assertEquals(mensalidade, estacionamento.getValorMensalidade());
		assertEquals(valorEvento, estacionamento.getValorEvento());
		assertEquals(horarioAbertura, estacionamento.getHorarioAbertura());
		assertEquals(horarioFechamento, estacionamento.getHorarioEncerramento());
		assertEquals(capacidade, estacionamento.getCapacidade());
		assertEquals(retornoContratante, estacionamento.getRetornoContratante());
	}

	@Test
	@Tag("TesteFuncional")
	void testCriaestacionamento1() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 1;
		Double valorFracao = 20.00;
		Double descontoHoraCheia = 10.0;
		Double valorDiariaDiurna = 70.00;
		Double descontoDiariaNoturna = 30.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(21, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(7, 0);
		Double mensalidade = 455.0;
		Double valorEvento = 60.0;
		LocalTime horarioAbertura = LocalTime.MIN;
		LocalTime horarioFechamento = LocalTime.MAX;
		Integer capacidade = 120;
		Double retornoContratante = 60.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Estacionamento estacionamento = assertDoesNotThrow(() -> {
			return estacionamentoBuilder.build();
		});

		assertEquals(id, estacionamento.getId());
		assertEquals(valorFracao, estacionamento.getValorFracao());
		assertEquals(descontoHoraCheia, estacionamento.getDescontoHoraCheia());
		assertEquals(valorDiariaDiurna, estacionamento.getValorDiariaDiurna());
		assertEquals(descontoDiariaNoturna, estacionamento.getDescontoDiariaNoturna());
		assertEquals(entradaDiariaNoturna, estacionamento.getHorarioEntradaDiariaNoturna());
		assertEquals(saidaDiariaNoturna, estacionamento.getHorarioSaidaDiariaNoturna());
		assertEquals(mensalidade, estacionamento.getValorMensalidade());
		assertEquals(valorEvento, estacionamento.getValorEvento());
		assertEquals(horarioAbertura, estacionamento.getHorarioAbertura());
		assertEquals(horarioFechamento, estacionamento.getHorarioEncerramento());
		assertEquals(capacidade, estacionamento.getCapacidade());
		assertEquals(retornoContratante, estacionamento.getRetornoContratante());
	}

	@Test
	@Tag("TesteFuncional")
	void testCriaestacionamento2() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 2;
		Double valorFracao = 10.00;
		Double descontoHoraCheia = 0.0;
		Double valorDiariaDiurna = 50.00;
		Double descontoDiariaNoturna = 40.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(20, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 350.0;
		Double valorEvento = 40.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 600;
		Double retornoContratante = 70.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Estacionamento estacionamento = assertDoesNotThrow(() -> {
			return estacionamentoBuilder.build();
		});

		assertEquals(id, estacionamento.getId());
		assertEquals(valorFracao, estacionamento.getValorFracao());
		assertEquals(descontoHoraCheia, estacionamento.getDescontoHoraCheia());
		assertEquals(valorDiariaDiurna, estacionamento.getValorDiariaDiurna());
		assertEquals(descontoDiariaNoturna, estacionamento.getDescontoDiariaNoturna());
		assertEquals(entradaDiariaNoturna, estacionamento.getHorarioEntradaDiariaNoturna());
		assertEquals(saidaDiariaNoturna, estacionamento.getHorarioSaidaDiariaNoturna());
		assertEquals(mensalidade, estacionamento.getValorMensalidade());
		assertEquals(valorEvento, estacionamento.getValorEvento());
		assertEquals(horarioAbertura, estacionamento.getHorarioAbertura());
		assertEquals(horarioFechamento, estacionamento.getHorarioEncerramento());
		assertEquals(capacidade, estacionamento.getCapacidade());
		assertEquals(retornoContratante, estacionamento.getRetornoContratante());
	}
}
