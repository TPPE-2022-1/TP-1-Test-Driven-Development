package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraValorRetornoContratanteEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorRetornoContratante() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double retornoContratante = 15.0;
		assertDoesNotThrow(() -> estacionamentoBuilder.setRetornoContratante(retornoContratante));
		assertEquals(retornoContratante, estacionamentoBuilder.getRetornoContratante());
	}

}
