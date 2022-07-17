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
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoZeroException;

public class RegistraValorMensalistaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getValorMensalidade() {
		return Stream.of(Arguments.of(400.00),
						Arguments.of(100.25),
						Arguments.of(0.52));
	}

	@ParameterizedTest
	@MethodSource("getValorMensalidade")
	@Tag("TesteFuncional")
	void testAdicionaValorMensalista(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double mensalidade = entrada;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorMensalidade(mensalidade));
		assertEquals(mensalidade, estacionamentoBuilder.getValorMensalidade());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorMensalistaInvalido0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorMensalidadeInvalidoZeroException.class,
				() -> estacionamentoBuilder.setValorMensalidade(0.00));
	}

	@Test
	@Tag("TesteExcecao")
	void testValorMensalistaInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorMensalidadeInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setValorMensalidade(-0.01));
	}
}
