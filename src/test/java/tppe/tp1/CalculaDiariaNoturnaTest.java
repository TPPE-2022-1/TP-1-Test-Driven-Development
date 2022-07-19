package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;


public class CalculaDiariaNoturnaTest {
	EstacionamentoBuilder eb;
	Estacionamento e;
	AcessoBuilder a;

	@BeforeEach
	void setUp() throws Exception {
		eb = new EstacionamentoBuilder();
		eb.setId(0);
		eb.setValorFracao(30.00);
		eb.setDescontoHoraCheia(15.00);
		eb.setValorDiariaDiurna(120.00);
		eb.setDescontoDiariaNoturna(45.00);
		eb.setHorarioEntradaDiariaNoturna(LocalTime.of(19, 0));
		eb.setHorarioSaidaDiariaNoturna(LocalTime.of(8, 0));
		eb.setValorMensalidade(600.00);
		eb.setValorEvento(50.00);
		eb.setHorarioAbertura(LocalTime.of(6, 0));
		eb.setHorarioEncerramento(LocalTime.of(22, 0));
		eb.setCapacidade(300);
		eb.setRetornoContratante(50.00);
		e = eb.build();
	}

	static Stream<Arguments> getAcesso() {
		return Stream.of(Arguments.of("2022-07-18T08:01", "2022-07-18T23:59", true),
						 Arguments.of("2022-07-18T08:00", "2022-07-18T18:00", false),
						 Arguments.of("2022-07-18T08:00", "2022-07-18T08:30", false),
						 // diária parcial
						 Arguments.of("2022-07-18T09:00", "2022-07-18T23:59", true),
						 Arguments.of("2022-07-18T19:01", "2022-07-19T01:00", true),
						 Arguments.of("2022-07-18T19:00", "2022-07-19T07:00", true),
						 Arguments.of("2022-07-18T01:00", "2022-07-19T07:00", true),
						 Arguments.of("2022-07-18T00:01", "2022-07-19T23:59", true));
	}

	@ParameterizedTest
	@MethodSource("getAcesso")
	@Tag("TesteFuncional")
	void testDiariaNoturna(String entrada, String saida, Boolean resposta) throws Exception {
		a = new AcessoBuilder();
		LocalDateTime horaEntrada = LocalDateTime.parse(entrada);
		LocalDateTime horaSaida = LocalDateTime.parse(saida);
		a.setHoraEntrada(horaEntrada);
		a.setHoraSaida(horaSaida);
		assertEquals(resposta, a.build().isDiariaNoturna(e));
	}
}
