package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

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
}
