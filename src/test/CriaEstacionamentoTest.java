package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Estacionamento;
import main.EstacionamentoBuilder;

class CriaEstacionamentoTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testAdicionaId() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();
		estacionamentoBuilder.setId(1);
		Estacionamento e = estacionamentoBuilder.build();
		assertEquals(1, e.getId());
	}

}
