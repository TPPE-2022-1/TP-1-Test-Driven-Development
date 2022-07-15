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
	void testAdicionaValorMensalista() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double mensalidade = 400.00;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorMensalidade(mensalidade));
		assertEquals(mensalidade, estacionamentoBuilder.getValorMensalidade());
	}
}
