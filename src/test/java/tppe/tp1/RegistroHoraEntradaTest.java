package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;

public class RegistroHoraEntradaTest {
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testRegistroHoraEntrada01() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaEntrada = LocalTime.parse("08:30");
		acessoBuilder.setHoraEntrada(horaEntrada);
		assertEquals(horaEntrada, acessoBuilder.getHoraEntrada());
		
	}

	@Test
	void testRegistroHoraEntrada02() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaEntrada = LocalTime.parse("12:12");
		acessoBuilder.setHoraEntrada(horaEntrada);
		assertEquals(horaEntrada, acessoBuilder.getHoraEntrada());
		
	}
	
	@Test
	void testRegistroHoraEntrada03() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		LocalTime horaEntrada = LocalTime.parse("19:59");
		acessoBuilder.setHoraEntrada(horaEntrada);
		assertEquals(horaEntrada, acessoBuilder.getHoraEntrada());
		
	}
}
