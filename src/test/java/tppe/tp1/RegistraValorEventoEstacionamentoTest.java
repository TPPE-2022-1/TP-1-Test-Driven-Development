package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraValorEventoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorEvento() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = 40.00;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorEvento(valorEvento));
		assertEquals(valorEvento, estacionamentoBuilder.getValorEvento());
	}
}
