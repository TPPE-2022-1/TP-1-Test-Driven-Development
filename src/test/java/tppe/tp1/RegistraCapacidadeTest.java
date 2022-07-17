package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaNegativaException;
import tppe.tp1.estacionamento.exceptions.EstacionamentoCapacidadeInvalidaZeroException;

public class RegistraCapacidadeTest {
	@BeforeEach
    public void setup() throws Exception {
    }

//     Parametrizacao de teste
    static Stream<Arguments> getCapacidade() {
        return Stream.of(Arguments.of(50),
                        Arguments.of(5),
                        Arguments.of(321)
        );
    }
    

	@ParameterizedTest
	@MethodSource("getCapacidade")
	@Tag("TesteFuncional")
	void testaInsereCapacidade(Integer entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setCapacidade(entrada));
		assertEquals(entrada, estacionamentoBuilder.getCapacidade());
	}
	
	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalido() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = 0;
		assertThrows(EstacionamentoCapacidadeInvalidaZeroException.class,
				() -> estacionamentoBuilder.setCapacidade(capacidade));
	}
	
	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalidoNegativo() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer capacidade = -1;
		assertThrows(EstacionamentoCapacidadeInvalidaNegativaException.class,
				() -> estacionamentoBuilder.setCapacidade(capacidade));
	}
}
