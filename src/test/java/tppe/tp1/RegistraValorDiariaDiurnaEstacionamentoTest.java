package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaDiurnaInvalidoZeroException;

public class RegistraValorDiariaDiurnaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaDiurna120() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorDiariaDiurna(120.00));
		assertEquals(120.00, estacionamentoBuilder.getValorDiariaDiurna());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaDiurna140() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorDiariaDiurna(140.00));
		assertEquals(140.00, estacionamentoBuilder.getValorDiariaDiurna());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaDiurna2525() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorDiariaDiurna(25.25));
		assertEquals(25.25, estacionamentoBuilder.getValorDiariaDiurna());
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
