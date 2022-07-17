package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
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
		a.setHoraEntrada(LocalTime.of(12, 0));
		a.setHoraSaida(LocalTime.of(15, 0));
	}
	
	@Tag("TesteFuncional")
	@ParameterizedTest
	@MethodSource("geraTipoAcesso")
	void checaTipoAcesso(String tipo, Boolean resultado) throws Exception {
		a.setTipoAcesso(tipo);
		acesso = a.build();
		assertEquals(resultado, acesso.isMensalista(acesso.getTipoAcesso()));
	}
	
	static Stream<Arguments> geraTipoAcesso() {
		return Stream.of(Arguments.of("Mensalista", true),
				Arguments.of("Evento", false),
				Arguments.of("Mensalista", true));
	}
}
