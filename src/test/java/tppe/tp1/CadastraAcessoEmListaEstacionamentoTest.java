package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CadastraAcessoEmListaEstacionamentoTest {
	private Estacionamento estacionamento;

	@BeforeEach
	void setup() {
		EstacionamentoBuilder e = new EstacionamentoBuilder();

		assertDoesNotThrow(() -> {
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
		});
	}

	@Test
	@Tag("TesteFuncional")
	void testCadastraAcessoEmListaEstacionamento() {
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		Acesso acesso;

		assertDoesNotThrow(() -> acessoBuilder.setPlaca("JHD9698"));
		acessoBuilder.setHoraEntrada(LocalDateTime.parse("2022-07-17T22:40"));
		acessoBuilder.setHoraSaida(LocalDateTime.parse("2022-07-17T23:30"));

		acesso = assertDoesNotThrow(() -> acessoBuilder.build());

		estacionamento.addAcesso(acesso);
		assertEquals(acesso, estacionamento.getAcesso(0));

	}

	@Test
	@Tag("TesteFuncional")
	void testCadastraAcessoEmListaEstacionamentoCheia() {
		AcessoBuilder acessoBuilder2 = new AcessoBuilder();
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		Acesso acesso, acesso2;

		assertDoesNotThrow(() -> acessoBuilder.setPlaca("GHJ7653"));
		acessoBuilder.setHoraEntrada(LocalDateTime.parse("2022-07-17T12:40"));
		acessoBuilder.setHoraSaida(LocalDateTime.parse("2022-07-17T15:30"));
		assertDoesNotThrow(() -> acessoBuilder2.setPlaca("XXX1234"));
		acessoBuilder2.setHoraEntrada(LocalDateTime.parse("2022-07-17T18:40"));
		acessoBuilder2.setHoraSaida(LocalDateTime.parse("2022-07-17T20:30"));

		acesso = assertDoesNotThrow(() -> acessoBuilder.build());
		acesso2 = assertDoesNotThrow(() -> acessoBuilder.build());

		estacionamento.addAcesso(acesso);
		estacionamento.addAcesso(acesso2);
		assertFalse(estacionamento.getListaAcessos().isEmpty());
		assertEquals(acesso, estacionamento.getListaAcessos().get(0));
		assertEquals(acesso2, estacionamento.getListaAcessos().get(1));
	}

}
