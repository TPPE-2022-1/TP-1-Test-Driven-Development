package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraHorarioAberturaTest {
	
	@BeforeEach
	public void setup() throws Exception{
	}
	
	
//  Parametrizacao de teste
	static Stream<Arguments> getHorarioAbertura() {
		return Stream.of(Arguments.of("06:00"),
                     	Arguments.of("06:30"),
                     	Arguments.of("00:00")
				);
	}
	
	@ParameterizedTest
	@MethodSource("getHorarioAbertura")
	@Tag("TesteFuncional")
	void testaInsereHorarioAbertura(String entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioAbertura = LocalTime.parse(entrada);
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioAbertura(horarioAbertura));
		assertEquals(horarioAbertura, estacionamentoBuilder.getHorarioAbertura());
	}

}
