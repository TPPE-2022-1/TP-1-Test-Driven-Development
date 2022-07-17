package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tppe.tp1.estacionamento.EstacionamentoBuilder;
import tppe.tp1.exceptions.DescricaoEmBrancoException;

public class CriaEstacionamentoIncompletoTest {

	@Test
	@Tag("TesteExcecao")
	void testEstacionamentoSemId() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Id não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testEstacionamentoSemValorFracao() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor fração não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemDescontoHoraCheia() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor desconto de hora cheia não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemValorDiariaDiurna() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor diária diurna não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemDescontoDiariaNoturna() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor desconto diária noturna não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemEntradaDiariaNoturna() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor horário entrada noturna não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemSaidaDiariaNoturna() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor horário saída noturna não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemMensalidade() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor mensalidade não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemEvento() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor evento não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemHorarioAbertura() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Horário abertura não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemHorarioFechamento() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		Integer capacidade = 300;
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setCapacidade(capacidade);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Horário fechamento não informado", exception.getMessage());
	}

	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemCapacidade() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Double retornoContratante = 50.0;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setRetornoContratante(retornoContratante);
		});

		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Valor capacidade não informado", exception.getMessage());
	}
	
	@Test
	@Tag("TesteExcecao")
	void testeEstacionamentoSemRetornoContratante() {
		EstacionamentoBuilder estacionamentoBuilder = new EstacionamentoBuilder();

		Integer id = 0;
		Double valorFracao = 30.00;
		Double descontoHoraCheia = 15.0;
		Double valorDiariaDiurna = 120.00;
		Double descontoDiariaNoturna = 45.0;
		LocalTime entradaDiariaNoturna = LocalTime.of(19, 0);
		LocalTime saidaDiariaNoturna = LocalTime.of(8, 0);
		Double mensalidade = 600.0;
		Double valorEvento = 50.0;
		LocalTime horarioAbertura = LocalTime.of(6, 0);
		LocalTime horarioFechamento = LocalTime.of(22, 0);
		Integer capacidade = 300;

		assertDoesNotThrow(() -> {
			estacionamentoBuilder.setId(id);
			estacionamentoBuilder.setValorFracao(valorFracao);
			estacionamentoBuilder.setDescontoHoraCheia(descontoHoraCheia);
			estacionamentoBuilder.setValorDiariaDiurna(valorDiariaDiurna);
			estacionamentoBuilder.setDescontoDiariaNoturna(descontoDiariaNoturna);
			estacionamentoBuilder.setHorarioEntradaDiariaNoturna(entradaDiariaNoturna);
			estacionamentoBuilder.setHorarioSaidaDiariaNoturna(saidaDiariaNoturna);
			estacionamentoBuilder.setValorMensalidade(mensalidade);
			estacionamentoBuilder.setValorEvento(valorEvento);
			estacionamentoBuilder.setHorarioAbertura(horarioAbertura);
			estacionamentoBuilder.setHorarioEncerramento(horarioFechamento);
			estacionamentoBuilder.setCapacidade(capacidade);
		});
		
		Exception exception = assertThrows(DescricaoEmBrancoException.class, () -> {
			estacionamentoBuilder.build();
		});
		assertEquals("Retorno contratante não informado", exception.getMessage());
	}
}
