package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.acesso.exceptions.AcessoEventoInvalidoException;
import tppe.tp1.acesso.exceptions.AcessoEventoVazioException;

public class RegistraTipoAcessoTest {

	AcessoBuilder acesso;
	
	
	@ParameterizedTest
	@MethodSource("geraTipoAcesso")
	@Tag("TesteFuncional")
	void testaInsereMensalista(String tipoAcesso) throws Exception {
		acesso = new AcessoBuilder();
		acesso.setTipoAcesso(tipoAcesso);

		assertEquals(tipoAcesso, acesso.getTipoAcesso());
	}

	static Stream<Arguments> geraTipoAcesso() {
		return Stream.of(Arguments.of("Mensalista"),
				Arguments.of("Evento"));
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
