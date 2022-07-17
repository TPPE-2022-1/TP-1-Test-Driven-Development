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
import tppe.tp1.estacionamento.exceptions.EstacionamentoIdInvalidoException;

public class RegistraIdEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
//     Parametrizacao de teste
    static Stream<Arguments> getId() {
        return Stream.of(Arguments.of(1),
                        Arguments.of(2),
                        Arguments.of(3000)
        );
    }
    
	@ParameterizedTest
	@MethodSource("getId")
	@Tag("TesteFuncional")
	void testAdicionaId(Integer entrada) {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> estacionamentoBuilder.setId(entrada));
		assertEquals(entrada, estacionamentoBuilder.getId());
	}


	@Test
	@Tag("TesteExcecao")
	void testAdicionaIdInvalido() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		assertThrows(EstacionamentoIdInvalidoException.class, () -> estacionamentoBuilder.setId(-1));
	}

}
