package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaNegativaException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaZeroException;

public class RegistraCapacidadeTest {
	@Test
	@Tag("TesteFuncional")
	void testaInsereCapacidade50() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = 50;
		assertDoesNotThrow(() -> estacionamentoBuilder.setCapacidade(capacidade));
		assertEquals(capacidade, estacionamentoBuilder.getCapacidade());
	}

	@Test
	@Tag("TesteFuncional")
	void testaInsereCapacidade5() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = 5;
		assertDoesNotThrow(() -> estacionamentoBuilder.setCapacidade(capacidade));
		assertEquals(capacidade, estacionamentoBuilder.getCapacidade());
	}

	@Test
	@Tag("TesteFuncional")
	void testaInsereCapacidade321() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = 321;
		assertDoesNotThrow(() -> estacionamentoBuilder.setCapacidade(capacidade));
		assertEquals(capacidade, estacionamentoBuilder.getCapacidade());
	}

	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalido0() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = 0;
		assertThrows(EstacionamentoCapacidadeInvalidaZeroException.class,
				() -> estacionamentoBuilder.setCapacidade(capacidade));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = -1;
		assertThrows(EstacionamentoCapacidadeInvalidaNegativaException.class,
				() -> estacionamentoBuilder.setCapacidade(capacidade));
	}
}
