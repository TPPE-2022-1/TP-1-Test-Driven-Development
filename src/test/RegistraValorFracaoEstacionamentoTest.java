package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import main.Estacionamento;
import main.EstacionamentoBuilder;
import main.EstacionamentoIdInvalidoException;

class RegistraValorFracaoEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	void test() {
		fail();
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao() throws EstacionamentoIdInvalidoException {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(30.00));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(30.00, e.getValorFracao());
	}

}
