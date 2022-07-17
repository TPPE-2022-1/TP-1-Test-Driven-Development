package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaFracoesTest {
	
	private Estacionamento estacionamento;
	
	@BeforeEach
	void setup() throws Exception {
		EstacionamentoBuilder e = new EstacionamentoBuilder();
		e.setId(0);
		e.setValorFracao(30.00);
		e.setDescontoHoraCheia(15.00);
		e.setValorDiariaDiurna(120.00);
		e.setDescontoDiariaNoturna(45.00);
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
	
	@Tag("TesteFuncional")
	@ParameterizedTest
	@MethodSource("geraAcessos")
	void testacalculoFracao(LocalTime horaEntrada, LocalTime horaSaida, Double total) throws Exception {
		assertEquals(total, estacionamento.calculaFracoes(horaEntrada, horaSaida), 0.1);
	}
	
	static Stream<Arguments> geraAcessos() {
		return Stream.of(Arguments.of(LocalTime.of(12, 0), LocalTime.of(12, 15), 30.00),
				Arguments.of(LocalTime.of(12, 00), LocalTime.of(12, 30), 60.00),
				Arguments.of(LocalTime.of(12, 00), LocalTime.of(12, 16), 60.00),
				Arguments.of(LocalTime.of(12, 00), LocalTime.of(12, 46), 0.00),
				Arguments.of(LocalTime.of(12, 00), LocalTime.of(12, 14), 30.00));
	}

}
