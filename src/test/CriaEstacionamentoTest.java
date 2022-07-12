package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Estacionamento;
import main.EstacionamentoBuilder;
import main.EstacionamentoIdInvalidoException;

class CriaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdicionaId1() throws Exception {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(1));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(1, e.getId());
	}

	@Test
	void testAdicionaId2() throws Exception {

		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(2));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(2, e.getId());
	}

	@Test
	void testAdicionaId3000() throws Exception {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(3000));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(3000, e.getId());
	}

	@Test
	void testAdicionaIdInvalido() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoIdInvalidoException.class, () -> estacionamentoBuilder.setId(-1));
	}

}
