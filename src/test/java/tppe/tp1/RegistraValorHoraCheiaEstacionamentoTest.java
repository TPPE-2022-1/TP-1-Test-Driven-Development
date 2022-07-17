package tppe.tp1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoMaior100Exception;
import tppe.tp1.estacionamento.exceptions.EstacionamentoValorHoraCheiaInvalidoNegativoException;

public class RegistraValorHoraCheiaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	//  Parametrizacao de teste
	static Stream<Arguments> getDescontoHoraCheia() {
		return Stream.of(Arguments.of(0.00),
						Arguments.of(10.00),
						Arguments.of(10.25),
						Arguments.of(99.99));
	}
	
	@ParameterizedTest
	@MethodSource("getDescontoHoraCheia")
	@Tag("TesteFuncional")
	void testAdicionaValorHoraCheia0(Double entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setDescontoHoraCheia(entrada));
		assertEquals(entrada, estacionamentoBuilder.getDescontoHoraCheia());
	}

	@Test
	@Tag("TesteExcecao")
	void testValorHoraCheiaInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorHoraCheiaInvalidoNegativoException.class,
				() -> estacionamentoBuilder.setDescontoHoraCheia(-0.01));
	}

	@Test
	@Tag("TesteExcecao")
	void testValorHoraCheiaInvalidoMaior100() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoValorHoraCheiaInvalidoMaior100Exception.class,
				() -> estacionamentoBuilder.setDescontoHoraCheia(100.01));
	}

}
