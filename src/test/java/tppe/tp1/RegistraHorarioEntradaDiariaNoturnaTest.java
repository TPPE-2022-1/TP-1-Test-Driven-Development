package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class RegistraHorarioEntradaDiariaNoturnaTest {

	@Test
	void testaInsereHorarioEntrada0000() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		LocalTime horarioEntradaDiariaNoturna = LocalTime.parse("00:00");
		assertDoesNotThrow(() -> estacionamentoBuilder.setHorarioEntradaDiariaNoturna(horarioEntradaDiariaNoturna));
		assertEquals(horarioEntradaDiariaNoturna, estacionamentoBuilder.getHorarioEntradaDiariaNoturna());
	}

}
