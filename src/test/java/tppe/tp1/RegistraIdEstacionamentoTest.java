package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegistraIdEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaId1() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(1));
		assertEquals(1, estacionamentoBuilder.getId());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaId2() {

		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(2));
		assertEquals(2, estacionamentoBuilder.getId());
	}

	@Test
	@Tag("TesteFuncional")
	void testAdicionaId3000() throws Exception {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(3000));
		assertEquals(3000, estacionamentoBuilder.getId());
	}

	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalido() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoIdInvalidoException.class, () -> estacionamentoBuilder.setId(-1));
	}

}
