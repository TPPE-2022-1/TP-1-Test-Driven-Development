package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CriaEstacionamentoTest {
	//  Parametrizacao de teste
	static Stream<Arguments> getConfiguracaoEstacionamento() {
		return Stream.of(Arguments.of(0, 30.00, 15.0, 120.00, 45.0, LocalTime.of(19, 0), LocalTime.of(8, 0),
									  600.0, 50.0, LocalTime.of(6, 0), LocalTime.of(22, 0), 300, 50.0),
						 Arguments.of(1, 20.00, 10.0, 70.00, 30.0, LocalTime.of(21, 0), LocalTime.of(7, 0),
							          455.0, 60.0, LocalTime.MIN, LocalTime.MAX, 120, 60.0),
						 Arguments.of(2, 10.00, 0.0, 50.00, 40.0, LocalTime.of(20, 0), LocalTime.of(8, 0),
							          350.0, 40.0, LocalTime.of(6, 0), LocalTime.of(22, 0), 600, 70.0));
	}
	
	@ParameterizedTest
	@MethodSource("getConfiguracaoEstacionamento")
	@Tag("TesteFuncional")
	void testCriaestacionamento(Integer id, Double valorFracao, Double descontoHoraCheia, Double valorDiariaDiurna,
								 Double descontoDiariaNoturna, LocalTime entradaDiariaNoturna, LocalTime saidaDiariaNoturna,
								 Double mensalidade, Double valorEvento, LocalTime horarioAbertura, LocalTime horarioFechamento,
								 Integer capacidade, Double retornoContratante){
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

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
