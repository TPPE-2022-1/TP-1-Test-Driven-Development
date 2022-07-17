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
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoZeroException;

public class RegistraValorRetornoContratanteEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getRetornoContratante() {
		return Stream.of(Arguments.of(15.0),
						Arguments.of(50.0),
						Arguments.of(30.30));
	}

	@ParameterizedTest
	@MethodSource("getRetornoContratante")
	@Tag("TesteFuncional")
	void testAdicionaValorRetornoContratante(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = entrada;
		assertDoesNotThrow(() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
		assertEquals(retornoContratante, estacionamentoBuilder.getRetornoContratante());
	}

	@Test
	@Tag("TesteExcecao")
	void testAdicionaRetornoContratanteInvalidoZero() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = 0.0;
		assertThrows(EstacionamentoRetornoContratanteInvalidoZeroException.class,
				() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
	}

	@Test
	@Tag("TesteExcecao")
	void testAdicionaRetornoContratanteInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = -0.01;
		assertThrows(EstacionamentoRetornoContratanteInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
	}

}
