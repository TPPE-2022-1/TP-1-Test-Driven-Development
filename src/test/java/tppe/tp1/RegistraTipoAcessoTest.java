package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.acesso.exceptions.AcessoEventoInvalidoException;
import tppe.tp1.acesso.exceptions.AcessoEventoVazioException;

public class RegistraTipoAcessoTest {
	
	@Test
	@Tag("TesteFuncional")
	void testaInsereMensalista() throws Exception {
		AcessoBuilder acesso = new AcessoBuilder();
		String tipoAcesso = "Mensalista";
		
		acesso.setTipoAcesso(tipoAcesso);
		assertEquals(tipoAcesso, acesso.getTipoAcesso());
	}
	
	@Test
	@Tag("TesteFuncional")
	void testaInsereEvento() throws Exception {
		AcessoBuilder acesso = new AcessoBuilder();
		String tipoAcesso = "Evento";
		
		acesso.setTipoAcesso(tipoAcesso);
		assertEquals(tipoAcesso, acesso.getTipoAcesso());
	}
	
	
	@Test
	@Tag("TesteExcecao")
	void testaInsereValorInvalido() {
		AcessoBuilder acesso = new AcessoBuilder();
		String tipoAcesso = "Event";
		
		assertThrows(AcessoEventoInvalidoException.class, () -> acesso.setTipoAcesso(tipoAcesso));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testaInsereValorVazio() {
		AcessoBuilder acesso = new AcessoBuilder();
		String tipoAcesso = " ";
		
		assertThrows(AcessoEventoVazioException.class, () -> acesso.setTipoAcesso(tipoAcesso));
	}

}
