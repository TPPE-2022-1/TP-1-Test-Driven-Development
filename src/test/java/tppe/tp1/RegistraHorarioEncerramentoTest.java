package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraHorarioEncerramentoTest {

	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioEncerramento2300() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEncerramento = LocalTime.parse("23:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEncerramento(horarioEncerramento));
		assertEquals(horarioEncerramento, estacionamentoBuilder.getHorarioEncerramento());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioEncerramento2230() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEncerramento = LocalTime.parse("22:30");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEncerramento(horarioEncerramento));
		assertEquals(horarioEncerramento, estacionamentoBuilder.getHorarioEncerramento());
	}

	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioEncerramento2359() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEncerramento = LocalTime.parse("23:59");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEncerramento(horarioEncerramento));
		assertEquals(horarioEncerramento, estacionamentoBuilder.getHorarioEncerramento());
	}
}
