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
	void testaInsereHorarioEntrada() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioAbertura = LocalTime.parse("06:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioAbertura(horarioAbertura));
		assertEquals(horarioAbertura, estacionamentoBuilder.getHorarioAbertura());
	}

}
