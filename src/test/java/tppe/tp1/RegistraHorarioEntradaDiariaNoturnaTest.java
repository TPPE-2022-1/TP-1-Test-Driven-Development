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

public class RegistraHorarioEntradaDiariaNoturnaTest {
	@BeforeEach
    public void setup() throws Exception {
    }

//     Parametrizacao de teste
    static Stream<Arguments> getHoraEntradaDiariaNoturna() {
        return Stream.of(Arguments.of("00:00"),
                        Arguments.of("23:59"),
                        Arguments.of("12:12")
        );
    }
    
	@ParameterizedTest
	@MethodSource("getHoraEntradaDiariaNoturna")
	@Tag("TesteFuncional")
	void testaInsereHorarioEntrada(String entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEntradaDiariaNoturna = LocalTime.parse(entrada);
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEntradaDiariaNoturna(horarioEntradaDiariaNoturna));
		assertEquals(horarioEntradaDiariaNoturna, estacionamentoBuilder.getHorarioEntradaDiariaNoturna());
	}


}
