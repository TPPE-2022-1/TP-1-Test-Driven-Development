package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorEventoInvalidoNegativoException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorMensalidadeInvalidoNegativoException;

public class RegistraValorEventoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorEvento40() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = 40.00;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorEvento(valorEvento));
		assertEquals(valorEvento, estacionamentoBuilder.getValorEvento());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorEvento0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = 0.00;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorEvento(valorEvento));
		assertEquals(valorEvento, estacionamentoBuilder.getValorEvento());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorEvento12345() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = 123.45;
		assertDoesNotThrow(() -> estacionamentoBuilder.setValorEvento(valorEvento));
		assertEquals(valorEvento, estacionamentoBuilder.getValorEvento());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorEventoInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorEvento = -0.01;
		assertThrows(EstacionamentoValorEventoInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setValorEvento(valorEvento));
	}
}
