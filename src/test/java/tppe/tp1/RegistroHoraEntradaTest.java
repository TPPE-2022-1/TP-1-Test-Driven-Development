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

public class RegistroHoraEntradaTest {
	@BeforeEach
	void setUp() throws Exception {
	}
	
	static Stream<Arguments> geraHoraEntrada() {
		return Stream.of(Arguments.of("08:30"),
				Arguments.of("12:30"),
				Arguments.of("19:19")
				);
	}
	
	
	@ParameterizedTest
	@MethodSource("geraHoraEntrada")
	@Tag("TesteFuncional")
	void testRegistroHoraEntrada01(String entrada) {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaEntrada = LocalTime.parse(entrada);
		acessoBuilder.setHoraEntrada(horaEntrada);
		assertEquals(horaEntrada, acessoBuilder.getHoraEntrada());
		
	}

	
}
