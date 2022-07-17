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
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorEventoInvalidoNegativoException;

public class RegistraValorEventoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getValorEvento() {
		return Stream.of(Arguments.of(40.00),
						Arguments.of(0.00),
						Arguments.of(123.45));
	}
	
	@ParameterizedTest
	@MethodSource("getValorEvento")
	@Tag("TesteFuncional")
	void testAdicionaValorEvento(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = entrada;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorEvento(valorEvento));
		assertEquals(valorEvento, estacionamentoBuilder.getValorEvento());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorEventoInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = -0.01;
		assertThrows(EstacionamentoValorEventoInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setValorEvento(valorEvento));
	}
}
