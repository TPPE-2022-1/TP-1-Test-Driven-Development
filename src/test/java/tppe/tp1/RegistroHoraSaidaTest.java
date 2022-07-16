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

public class RegistroHoraSaidaTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	static Stream<Arguments> geraHoraSaida() {
		return Stream.of(Arguments.of("08:30"),
				Arguments.of("14:30"),
				Arguments.of("19:19")
				);
	}
	
	@ParameterizedTest
	@MethodSource("geraHoraSaida")
	@Tag("TesteFuncional")
	void testRegistroHoraSaida(String saida) {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaSaida = LocalTime.parse(saida);
		acessoBuilder.setHoraSaida(horaSaida);
		assertEquals(horaSaida, acessoBuilder.getHoraSaida());
		
	}

}
