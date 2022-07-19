package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class CalculaValorAcessoTest {
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

	@ParameterizedTest
	@MethodSource("geraAcessos")
	@Tag("TesteFuncional")
	void calculaValorAcessTest(String placa, String entrada, String saida, String tipoAcesso, Double resultado) throws Exception {
		AcessoBuilder a = new AcessoBuilder();
		a.setPlaca(placa);
		a.setHoraEntrada(LocalDateTime.parse(entrada));
		a.setHoraSaida(LocalDateTime.parse(saida));
		a.setTipoAcesso(tipoAcesso);
		
		acesso = a.build();
		assertEquals(resultado, estacionamento.calculaValorTotal(acesso), 0.1);
	}
	
	
	static Stream<Arguments> geraAcessos() {
		return Stream.of(Arguments.of("LZY5677", "2022-07-18T08:01", "2022-07-18T08:01", "", 0.00),
					Arguments.of("GWO6601", "2022-07-18T08:30", "2022-07-18T08:56", "", 40.00),
					Arguments.of("IFE1085", "2022-07-18T08:00", "2022-07-18T18:00", "", 70.00),
					Arguments.of("JJL2180", "2022-07-18T21:36", "2022-07-19T06:12", "", 21.00),
					Arguments.of("JJL2180", "2022-07-18T21:36", "2022-07-19T06:12", "Mensalista", 455.00),
					Arguments.of("JJL2180", "2022-07-18T21:36", "2022-07-19T06:12", "Evento", 60.00));
	}
}
