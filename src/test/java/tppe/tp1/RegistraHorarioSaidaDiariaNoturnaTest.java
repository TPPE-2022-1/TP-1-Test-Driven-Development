package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class RegistraHorarioSaidaDiariaNoturnaTest {

	@Test
	void testaInsereHorarioSaida0300() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioSaidaDiariaNoturna = LocalTime.parse("03:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioSaidaDiariaNoturna(horarioSaidaDiariaNoturna));
		assertEquals(horarioSaidaDiariaNoturna, estacionamentoBuilder.getHorarioSaidaDiariaNoturna());
	}
	
	@Test
	void testaInsereHorarioSaida0935() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioSaidaDiariaNoturna = LocalTime.parse("09:35");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioSaidaDiariaNoturna(horarioSaidaDiariaNoturna));
		assertEquals(horarioSaidaDiariaNoturna, estacionamentoBuilder.getHorarioSaidaDiariaNoturna());
	}
	
	@Test
	void testaInsereHorarioSaida1205() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioSaidaDiariaNoturna = LocalTime.parse("12:05");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioSaidaDiariaNoturna(horarioSaidaDiariaNoturna));
		assertEquals(horarioSaidaDiariaNoturna, estacionamentoBuilder.getHorarioSaidaDiariaNoturna());
	}
}
