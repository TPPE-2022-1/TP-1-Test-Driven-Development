package tppe.tp1.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import tppe.tp1.CadastraAcessoEmListaEstacionamentoTest;
import tppe.tp1.CalculaDiariaDiurnaTest;
import tppe.tp1.CalculaDiariaNoturnaTest;
import tppe.tp1.CalculaFracoesTest;
import tppe.tp1.CalculaHoraCheiaTest;
import tppe.tp1.CalculaValorAcessoTest;
import tppe.tp1.CalculaValorContratanteTest;
import tppe.tp1.CalculaValorTotalTest;
import tppe.tp1.ChecaTipoEventoTest;
import tppe.tp1.ChecaTipoMensalistaTest;
import tppe.tp1.CriaAcessoTest;
import tppe.tp1.CriaEstacionamentoIncompletoTest;
import tppe.tp1.CriaEstacionamentoParametrosInvalidosTest;
import tppe.tp1.CriaEstacionamentoTest;
import tppe.tp1.RegistraCapacidadeTest;
import tppe.tp1.RegistraHorarioAberturaTest;
import tppe.tp1.RegistraHorarioEncerramentoTest;
import tppe.tp1.RegistraHorarioEntradaDiariaNoturnaTest;
import tppe.tp1.RegistraHorarioSaidaDiariaNoturnaTest;
import tppe.tp1.RegistraIdEstacionamentoTest;
import tppe.tp1.RegistraTipoAcessoTest;
import tppe.tp1.RegistraValorDiariaDiurnaEstacionamentoTest;
import tppe.tp1.RegistraValorDiariaNoturnaEstacionamentoTest;
import tppe.tp1.RegistraValorEventoEstacionamentoTest;
import tppe.tp1.RegistraValorFracaoEstacionamentoTest;
import tppe.tp1.RegistraValorHoraCheiaEstacionamentoTest;
import tppe.tp1.RegistraValorMensalistaEstacionamentoTest;
import tppe.tp1.RegistraValorRetornoContratanteEstacionamentoTest;
import tppe.tp1.RegistroHoraEntradaTest;
import tppe.tp1.RegistroHoraSaidaTest;
import tppe.tp1.RegistroPlacaTest;

@Suite
@SelectClasses({ CadastraAcessoEmListaEstacionamentoTest.class, CalculaDiariaDiurnaTest.class,
		CalculaDiariaNoturnaTest.class, CalculaFracoesTest.class, CalculaHoraCheiaTest.class,
		CalculaValorAcessoTest.class, CalculaValorTotalTest.class, ChecaTipoEventoTest.class,
		ChecaTipoMensalistaTest.class, CriaAcessoTest.class, CriaEstacionamentoIncompletoTest.class,
		CriaEstacionamentoParametrosInvalidosTest.class, CriaEstacionamentoTest.class, RegistraCapacidadeTest.class,
		RegistraHorarioAberturaTest.class, RegistraHorarioEncerramentoTest.class,
		RegistraHorarioEntradaDiariaNoturnaTest.class, RegistraHorarioSaidaDiariaNoturnaTest.class,
		RegistraIdEstacionamentoTest.class, RegistraTipoAcessoTest.class,
		RegistraValorDiariaDiurnaEstacionamentoTest.class, RegistraValorDiariaNoturnaEstacionamentoTest.class,
		RegistraValorFracaoEstacionamentoTest.class, RegistraValorEventoEstacionamentoTest.class,
		RegistraValorHoraCheiaEstacionamentoTest.class, RegistraValorMensalistaEstacionamentoTest.class,
		RegistraValorRetornoContratanteEstacionamentoTest.class, RegistroHoraEntradaTest.class,
		RegistroHoraSaidaTest.class, RegistroPlacaTest.class, CalculaValorContratanteTest.class})
@IncludeTags("TesteExcecao")
@SuiteDisplayName("Testes de Excecao")
class TestesExcecaoTest {
}
