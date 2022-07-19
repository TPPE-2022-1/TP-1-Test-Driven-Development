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

public class ChecaTipoMensalistaTest {

	Acesso acesso;
	AcessoBuilder a = new AcessoBuilder();
	
	@BeforeEach
	void setup() throws Exception {
		a.setPlaca("JIL2809");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T12:00"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-18T15:00"));
	}
	
	@Tag("TesteFuncional")
	@ParameterizedTest
	@MethodSource("geraTipoAcesso")
	void checaTipoAcesso(String tipo, Boolean resultado) throws Exception {
		a.setTipoAcesso(tipo);
		acesso = a.build();
		assertEquals(resultado, acesso.isMensalista());
	}
	
	static Stream<Arguments> geraTipoAcesso() {
		return Stream.of(Arguments.of("Mensalista", true),
				Arguments.of("Evento", false),
				Arguments.of("Mensalista", true));
	}
}
