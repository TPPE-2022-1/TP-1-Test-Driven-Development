package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;

public class CriaAcessoTest {

	@Test
	@Tag("TesteFuncional")
	void testCriaAcesso() throws Exception  {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		
		String placa = "JJO0830";
		LocalTime horaEntrada = LocalTime.of(14, 30);
		LocalTime horaSaida = LocalTime.of(07, 30);
		
		acessoBuilder.setPlaca(placa);
		acessoBuilder.setHoraEntrada(horaEntrada);
		acessoBuilder.setHoraSaida(horaSaida);
		
		Acesso acesso = acessoBuilder.build();
		
		assertEquals(placa, acesso.getPlaca());
		assertEquals(horaEntrada, acesso.getHoraEntrada());
		assertEquals(horaSaida, acesso.getHoraSaida());
	}

	@Test
	@Tag("TesteFuncional")
	void testCriaAcessoD() throws Exception  {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		
		String placa = "JGC2830";
		LocalTime horaEntrada = LocalTime.of(10, 30);
		LocalTime horaSaida = LocalTime.of(15, 30);
		
		acessoBuilder.setPlaca(placa);
		acessoBuilder.setHoraEntrada(horaEntrada);
		acessoBuilder.setHoraSaida(horaSaida);
		
		Acesso acesso = acessoBuilder.build();
		
		assertEquals(placa, acesso.getPlaca());
		assertEquals(horaEntrada, acesso.getHoraEntrada());
		assertEquals(horaSaida, acesso.getHoraSaida());
	}

	@Test
	@Tag("TesteFuncional")
	void testCriaAcessoT() throws Exception  {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		
		String placa = "JHX1785";
		LocalTime horaEntrada = LocalTime.of(7, 30);
		LocalTime horaSaida = LocalTime.of(15, 30);
		
		acessoBuilder.setPlaca(placa);
		acessoBuilder.setHoraEntrada(horaEntrada);
		acessoBuilder.setHoraSaida(horaSaida);
		
		Acesso acesso = acessoBuilder.build();
		
		assertEquals(placa, acesso.getPlaca());
		assertEquals(horaEntrada, acesso.getHoraEntrada());
		assertEquals(horaSaida, acesso.getHoraSaida());
	}
}
