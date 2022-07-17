package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;

public class ChecaTipoEventoTest {


	Acesso acesso;
	AcessoBuilder a = new AcessoBuilder();
	
	@BeforeEach
	void setup() throws Exception {
		a.setPlaca("JHS1227");
		a.setHoraEntrada(LocalTime.of(8, 0));
		a.setHoraSaida(LocalTime.of(12, 0));
	}
	
	@Test
	@Tag("TesteFuncional")
	void checaTipoEntrada() throws Exception {
		a.setTipoAcesso("Evento");
		acesso = a.build();
		assertTrue(acesso.isEvento(acesso.getTipoAcesso()));
	}
	
	
	@Test
	@Tag("TesteFuncional")
	void checaTipoEntradaD() throws Exception {
		a.setTipoAcesso("Mensalista");
		acesso = a.build();
		assertFalse(acesso.isEvento(acesso.getTipoAcesso()));
	}
	
	
}
