package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraHorarioEncerramentoTest {
	@BeforeEach
    public void setup() throws Exception {
    }

//     Parametrizacao de teste
    static Stream<Arguments> getHorarioEncerramento() {
        return Stream.of(Arguments.of("23:00"),
                        Arguments.of("22:30"),
                        Arguments.of("23:59")
        );
    }
    
	@ParameterizedTest
	@MethodSource("getHorarioEncerramento")
	@Tag("TesteFuncional")
	void testaInsereHorarioEncerramento(String entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEncerramento = LocalTime.parse(entrada);
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEncerramento(horarioEncerramento));
		assertEquals(horarioEncerramento, estacionamentoBuilder.getHorarioEncerramento());
	}
	
}
