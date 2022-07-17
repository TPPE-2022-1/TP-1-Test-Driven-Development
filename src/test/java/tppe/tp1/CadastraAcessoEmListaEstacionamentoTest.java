package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CadastraAcessoEmListaEstacionamentoTest {
	private Estacionamento estacionamento;
	
	@BeforeEach
	void setup() throws Exception {
		EstacionamentoBuilder e = new EstacionamentoBuilder();
		e.setId(0);
		e.setValorFracao(30.00);
		e.setDescontoHoraCheia(15.00);
		e.setValorDiariaDiurna(120.00);
		e.setDescontoDiariaNoturna(45.00);
		e.setHorarioEntradaDiariaNoturna(LocalTime.of(19, 0));
		e.setHorarioSaidaDiariaNoturna(LocalTime.of(8, 0));
		e.setValorMensalidade(600.00);
		e.setValorEvento(50.00);
		e.setHorarioAbertura(LocalTime.of(6, 0));
		e.setHorarioEncerramento(LocalTime.of(22, 0));
		e.setCapacidade(300);
		e.setRetornoContratante(50.00);
		this.estacionamento = e.build();
	}
	
	@Test
	@Tag("TesteFuncional")
	void testCadastraAcessoEmListaEstacionamento() throws Exception {		
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		Acesso acesso;
		
		acessoBuilder.setPlaca("JHD9698");
		acessoBuilder.setHoraEntrada(LocalTime.of(22, 40));
		acessoBuilder.setHoraSaida(LocalTime.of(23, 30));
		
		acesso = acessoBuilder.build();
		
		estacionamento.addAcesso(acesso);
		assertEquals(acesso, estacionamento.getAcesso(0));
		
	}

}
