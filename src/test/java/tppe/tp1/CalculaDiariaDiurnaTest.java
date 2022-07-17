package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.EstacionamentoBuilder;


public class CalculaDiariaDiurnaTest {
	EstacionamentoBuilder e;
	AcessoBuilder a;

	@BeforeEach
	void setUp() throws Exception {
		e = new EstacionamentoBuilder();
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
	}
	
	static Stream<Arguments> getAcesso() {
		return Stream.of(Arguments.of("08:00", "18:00", true),
						 Arguments.of("11:00", "19:00", false),
						 Arguments.of("10:00", "09:00", true),
						 Arguments.of("18:00", "17:00", true),
						 Arguments.of("15:00", "23:00", false),
						 Arguments.of("23:00", "17:00", true),
						 Arguments.of("23:00", "09:00", false));
	}

	@ParameterizedTest
	@MethodSource("getAcesso")
	@Tag("TesteFuncional")
	void testDiariaDiurna(String entrada, String saida, Boolean resposta) {
		a = new AcessoBuilder();
		LocalTime horaEntrada = LocalTime.parse(entrada);
		LocalTime horaSaida = LocalTime.parse(saida);
		a.setHoraEntrada(horaEntrada);
		a.setHoraSaida(horaSaida);
		assertEquals(resposta, a.isDiariaDiurna(e));
	}
		
}
