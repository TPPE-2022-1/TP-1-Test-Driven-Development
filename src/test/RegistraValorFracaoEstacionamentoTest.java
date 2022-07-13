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
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao30() throws EstacionamentoIdInvalidoException {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(30.00));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(30.00, e.getValorFracao());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao015() throws EstacionamentoIdInvalidoException {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(0.15));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(0.15, e.getValorFracao());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testAdicionaValorFracao101() throws EstacionamentoIdInvalidoException {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setValorFracao(1.01));
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(1.01, e.getValorFracao());
	}

}
