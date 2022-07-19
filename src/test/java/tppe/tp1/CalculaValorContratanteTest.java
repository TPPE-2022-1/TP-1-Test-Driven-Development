package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaValorContratanteTest {
	Acesso acesso;
	Estacionamento estacionamento;
	
	@BeforeEach
	void setup() throws Exception {
		EstacionamentoBuilder e = new EstacionamentoBuilder();
		e.setId(0);
		e.setValorFracao(20.00);
		e.setDescontoHoraCheia(10.00);
		e.setValorDiariaDiurna(70.00);
		e.setDescontoDiariaNoturna(30.00);
		e.setHorarioEntradaDiariaNoturna(LocalTime.of(21, 0));
		e.setHorarioSaidaDiariaNoturna(LocalTime.of(7, 0));
		e.setValorMensalidade(455.00);
		e.setValorEvento(60.00);
		e.setHorarioAbertura(LocalTime.of(0, 0));
		e.setHorarioEncerramento(LocalTime.of(23, 59));
		e.setCapacidade(120);
		e.setRetornoContratante(60.00);
		this.estacionamento = e.build();
	}
	
	@Test
	@Tag("TesteFuncional")
	void testCalculaValorContratante() throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca("MWS3805");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T08:30"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-18T08:56"));
		a.setValorAcesso(40.00);

		acesso = a.build();
		assertEquals(24.00, acesso.calculoValorContratante(estacionamento.getRetornoContratante()), 0.1);
	}
	

	
	@Test
	@Tag("TesteFuncional")
	void testCalculaValorContratanteD() throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca("JJL2180");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T21:36"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-19T06:12"));
		a.setTipoAcesso("Mensalista");
		a.setValorAcesso(455.00);
		
		acesso = a.build();
		assertEquals(273.00, acesso.calculoValorContratante(estacionamento.getRetornoContratante()), 0.1);
	}

	
	@Test
	@Tag("TesteFuncional")
	void testCalculaValorContratanteT() throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca("JJL2180");
		a.setHoraEntrada(LocalDateTime.parse("2022-07-18T21:36"));
		a.setHoraSaida(LocalDateTime.parse("2022-07-19T06:12"));
		a.setTipoAcesso("");
		a.setValorAcesso(21.00);

		acesso = a.build();
		assertEquals(12.60, acesso.calculoValorContratante(estacionamento.getRetornoContratante()), 0.1);
	}
	
	

}
