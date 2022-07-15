package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistraValorDiariaNoturnaEstacionamentoTest {

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

}
