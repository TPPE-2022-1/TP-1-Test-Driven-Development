package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoNegativoException;

public class RegistraValorDiariaNoturnaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getDescontoDiariaNoturna() {
		return Stream.of(Arguments.of(0.00),
						Arguments.of(10.00),
						Arguments.of(99.99)
				);
	}

	@ParameterizedTest
	@MethodSource("getDescontoDiariaNoturna")
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaNoturna(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoDiariaNoturna(entrada));
		assertEquals(entrada, estacionamentoBuilder.getDescontoDiariaNoturna());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorDiariaNoturnaInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorDiariaNoturnaInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setDescontoDiariaNoturna(-0.01));
	}

	@Test
	@Tag("TesteExcecao")
	void testValorDiariaNoturnaInvalidoMaior100() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception.class,
				() -> estacionamentoBuilder.setDescontoDiariaNoturna(100.01));
	}

}
