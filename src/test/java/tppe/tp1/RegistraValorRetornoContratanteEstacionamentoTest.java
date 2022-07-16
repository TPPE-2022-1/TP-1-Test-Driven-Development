package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoRetornoContratanteInvalidoZeroException;

public class RegistraValorRetornoContratanteEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorRetornoContratante15() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = 15.0;
		assertDoesNotThrow(() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
		assertEquals(retornoContratante, estacionamentoBuilder.getRetornoContratante());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorRetornoContratante50() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = 50.0;
		assertDoesNotThrow(() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
		assertEquals(retornoContratante, estacionamentoBuilder.getRetornoContratante());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorRetornoContratante3030() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = 30.30;
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
