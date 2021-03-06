package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;

public class ChecaTipoEventoTest {

	Acesso acesso;
	AcessoBuilder a = new AcessoBuilder();

	@BeforeEach
	void setup() throws Exception {
		a.setPlaca("JHS1227");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T08:00"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-18T12:00"));
	}

	@Tag("TesteFuncional")
	@ParameterizedTest
	@MethodSource("geraTipoAcesso")
	void checaTipoEntrada(String tipoAcesso, Boolean resultado) throws Exception {
		a.setTipoAcesso(tipoAcesso);
		acesso = a.build();
		assertEquals(resultado, acesso.isEvento());
	}

	static Stream<Arguments> geraTipoAcesso() {
		return Stream.of(Arguments.of("Evento", true), Arguments.of("Mensalista", false), Arguments.of("Evento", true));
	}
}
