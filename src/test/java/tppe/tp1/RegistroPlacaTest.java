package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.acesso.exceptions.AcessoPlacaInvalidaException;


public class RegistroPlacaTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	@Tag("TesteFuncional")
	void testRegistraPlaca01() {
	AcessoBuilder acessoBuilder = new AcessoBuilder();
	String placa = "JKI0002";
	
	assertDoesNotThrow(() -> acessoBuilder.setPlaca(placa));
	assertEquals(placa, acessoBuilder.getPlaca());
}
	
	@Test
	@Tag("TesteFuncional")
	void testRegistraPlaca02() {
	AcessoBuilder acessoBuilder = new AcessoBuilder();
	String placa = "JKI0003";
	
	assertDoesNotThrow(() -> acessoBuilder.setPlaca(placa));
	assertEquals(placa, acessoBuilder.getPlaca());
}
	
	@Test
	@Tag("TesteFuncional")
	void testRegistraPlaca03() {
	AcessoBuilder acessoBuilder = new AcessoBuilder();
	String placa = "JKI0004";
	
	assertDoesNotThrow(() -> acessoBuilder.setPlaca(placa));
	assertEquals(placa, acessoBuilder.getPlaca());
}
	
	@Test
	@Tag("TesteExcecao")
	void testRegistraPlacaInvalido() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		
		String placa = "JK0001";
		assertThrows(AcessoPlacaInvalidaException.class, () -> acessoBuilder.setPlaca(placa));
		
	}
}
