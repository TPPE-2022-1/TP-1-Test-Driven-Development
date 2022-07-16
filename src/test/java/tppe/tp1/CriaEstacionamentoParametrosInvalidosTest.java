package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoHorariosAberturaEncerramentoInvalidos;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValoresNoturnosInvalidos;

public class CriaEstacionamentoParametrosInvalidosTest {

	@Test
	@Tag("TesteExcecao")
	void testHorariosNoturnosInvalidos() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(8, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(19, 0);
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

		Exception exception = assertThrows(EstacionamentoValoresNoturnosInvalidos.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Horário de entrada deve posterior ao de saída, por acontecer no dia anterior",
				exception.getMessage());
	}
	
	@Test
	@Tag("TesteExcecao")
	void testAberturaFechamentoInvalidos() {
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
		LocalTime horarioAbertura = LocalTime.of(22, 0);
		LocalTime horarioFechamento = LocalTime.of(6, 0);
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

		Exception exception = assertThrows(EstacionamentoHorariosAberturaEncerramentoInvalidos.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Horário de abertura deve ser anterior ao de encerramento",
				exception.getMessage());
	}
}
