package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class RegistraHorarioAberturaTest {

	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioAbertura0600() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioAbertura = LocalTime.parse("06:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioAbertura(horarioAbertura));
		assertEquals(horarioAbertura, estacionamentoBuilder.getHorarioAbertura());
	}

	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioAbertura0630() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioAbertura = LocalTime.parse("06:30");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioAbertura(horarioAbertura));
		assertEquals(horarioAbertura, estacionamentoBuilder.getHorarioAbertura());
	}

	@Test
	@Tag("TesteFuncional")
	void testaInsereHorarioAbertura0000() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioAbertura = LocalTime.parse("00:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioAbertura(horarioAbertura));
		assertEquals(horarioAbertura, estacionamentoBuilder.getHorarioAbertura());
	}

}
