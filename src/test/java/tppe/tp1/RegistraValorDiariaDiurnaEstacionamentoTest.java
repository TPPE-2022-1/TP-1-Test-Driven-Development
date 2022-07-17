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
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoZeroException;

public class RegistraValorDiariaDiurnaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//  Parametrizacao de teste
	static Stream<Arguments> getValorDiariaDiurna() {
		return Stream.of(Arguments.of(120.00),
						Arguments.of(140.00),
						Arguments.of(25.25)
				);
	}
	
	@ParameterizedTest
	@MethodSource("getValorDiariaDiurna")
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaDiurna(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorDiariaDiurna(entrada));
		assertEquals(entrada, estacionamentoBuilder.getValorDiariaDiurna());
	}
	
	@Test
	@Tag("TesteExcecao")
	void testValorDiariaDiurnaInvalido0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorDiariaDiurnaInvalidoZeroException.class,
				() -> estacionamentoBuilder.setValorDiariaDiurna(0.00));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testValorDiariaDiurnaInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorDiariaDiurnaInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setValorDiariaDiurna(-0.01));
	}

}
