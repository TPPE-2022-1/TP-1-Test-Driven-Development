package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.exceptions.DescricaoEmBrancoException;

public class CriaEstacionamentoIncompletoTest {

	@Test
	@Tag("TesteExcecao")
	void testEstacionamentoSemId() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

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

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Id não informado", exception.getMessage());
	}

}
