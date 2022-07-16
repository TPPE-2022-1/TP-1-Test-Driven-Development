package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorDiariaNoturnaInvalidoNegativoException;

public class RegistraValorDiariaNoturnaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaNoturna0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoDiariaNoturna(0.00));
		assertEquals(0.00, estacionamentoBuilder.getDescontoDiariaNoturna());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaNoturna10() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoDiariaNoturna(10.00));
		assertEquals(10.00, estacionamentoBuilder.getDescontoDiariaNoturna());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorDiariaNoturna9999() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoDiariaNoturna(99.99));
		assertEquals(99.99, estacionamentoBuilder.getDescontoDiariaNoturna());
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
