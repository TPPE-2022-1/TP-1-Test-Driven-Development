package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistraValorMensalistaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorMensalista400() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double mensalidade = 400.00;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorMensalidade(mensalidade));
		assertEquals(mensalidade, estacionamentoBuilder.getValorMensalidade());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorMensalista10025() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double mensalidade = 100.25;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorMensalidade(mensalidade));
		assertEquals(mensalidade, estacionamentoBuilder.getValorMensalidade());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorMensalista052() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double mensalidade = 0.52;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorMensalidade(mensalidade));
		assertEquals(mensalidade, estacionamentoBuilder.getValorMensalidade());
	}
}
