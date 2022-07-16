package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorFracaoInvalidoZeroException;

public class RegistraValorFracaoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao30() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(30.00));
		assertEquals(30.00, estacionamentoBuilder.getValorFracao());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao015() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(0.15));
		assertEquals(0.15, estacionamentoBuilder.getValorFracao());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao101() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(1.01));
		assertEquals(1.01, estacionamentoBuilder.getValorFracao());
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
