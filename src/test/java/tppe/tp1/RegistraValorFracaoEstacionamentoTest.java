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
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoZeroException;

public class RegistraValorFracaoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getValorFracao() {
		return Stream.of(Arguments.of(30.00),
						Arguments.of(0.15),
						Arguments.of(1.01));
	}
	
	@ParameterizedTest
	@MethodSource("getValorFracao")
	@Tag("TesteFuncional")
	void testAdicionaValorFracao(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(entrada));
		assertEquals(entrada, estacionamentoBuilder.getValorFracao());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorFracaoInvalido0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorFracaoInvalidoZeroException.class,
				() -> estacionamentoBuilder.setValorFracao(0.00));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testValorFracaoInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorFracaoInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setValorFracao(-0.01));
	}

}
