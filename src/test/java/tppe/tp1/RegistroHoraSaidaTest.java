package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;

public class RegistroHoraSaidaTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	@Tag("TesteFuncional")
	void testRegistroHoraSaida01() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaSaida = LocalTime.parse("08:30");
		acessoBuilder.setHoraSaida(horaSaida);
		assertEquals(horaSaida, acessoBuilder.getHoraSaida());
		
	}
	
	@Test
	@Tag("TesteFuncional")
	void testRegistroHoraSaida02() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaSaida = LocalTime.parse("11:30");
		acessoBuilder.setHoraSaida(horaSaida);
		assertEquals(horaSaida, acessoBuilder.getHoraSaida());
		
	}
	
	
	@Test
	@Tag("TesteFuncional")
	void testRegistroHoraSaida03() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaSaida = LocalTime.parse("23:29");
		acessoBuilder.setHoraSaida(horaSaida);
		assertEquals(horaSaida, acessoBuilder.getHoraSaida());
		
	}
}
