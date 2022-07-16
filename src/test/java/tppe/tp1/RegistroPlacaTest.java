package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;
import tppe.tp1.acesso.exceptions.AcessoPlacaVazioException;


public class RegistroPlacaTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	static Stream<Arguments> geraPlaca() {
		return Stream.of(Arguments.of("JZM3110"),
				Arguments.of("MZQ2793"),
				Arguments.of("NEO6348")
				);
	}
	
	static Stream<Arguments> geraExecoes() {
		return Stream.of(Arguments.of("1"),
				Arguments.of("MZQ279312"),
				Arguments.of("NEO634812312312312312315530")
				);
	}
	
	@ParameterizedTest
	@MethodSource("geraPlaca")
	@Tag("TesteFuncional")
	void testRegistraPlaca01(String placa) {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		
		assertDoesNotThrow(() -> acessoBuilder.setPlaca(placa));
		assertEquals(placa, acessoBuilder.getPlaca());
	}
	

	@ParameterizedTest
	@MethodSource("geraExecoes")
	@Tag("TesteExcecao")
	void testRegistraPlacaInvalido(String placa) {
		AcessoBuilder acessoBuilder = new AcessoBuilder();

		assertThrows(AcessoPlacaInvalidaException.class, () -> acessoBuilder.setPlaca(placa));
		
	}
	
	@Test
	@Tag("TesteExcecao")
	void testRegistraPlacaVazio() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		String placa = "";
		assertThrows(AcessoPlacaVazioException.class, () -> acessoBuilder.setPlaca(placa));
		
	}
	
}
