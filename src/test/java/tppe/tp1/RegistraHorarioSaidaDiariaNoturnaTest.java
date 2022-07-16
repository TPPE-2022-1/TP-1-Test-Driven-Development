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

public class RegistraHorarioSaidaDiariaNoturnaTest {
	
	@BeforeEach
    public void setup() throws Exception {
    }

//     Parametrizacao de teste
    static Stream<Arguments> getHoraSaidaDiariaNoturna() {
        return Stream.of(Arguments.of("03:00"),
                        Arguments.of("09:35"),
                        Arguments.of("12:05")
        );
    }
    
	@ParameterizedTest
	@MethodSource("getHoraSaidaDiariaNoturna")
	@Tag("TesteFuncional")
	void testaInsereHorarioSaida0300(String entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioSaidaDiariaNoturna = LocalTime.parse(entrada);
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioSaidaDiariaNoturna(horarioSaidaDiariaNoturna));
		assertEquals(horarioSaidaDiariaNoturna, estacionamentoBuilder.getHorarioSaidaDiariaNoturna());
	}
	
}
