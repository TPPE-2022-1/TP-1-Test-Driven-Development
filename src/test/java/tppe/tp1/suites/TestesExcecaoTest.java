package tppe.tp1.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import tppe.tp1.RegistraHorarioEntradaDiariaNoturnaTest;
import tppe.tp1.RegistraHorarioSaidaDiariaNoturnaTest;
import tppe.tp1.RegistraIdEstacionamentoTest;
import tppe.tp1.RegistraValorDiariaDiurnaEstacionamentoTest;
import tppe.tp1.RegistraValorDiariaNoturnaEstacionamentoTest;
import tppe.tp1.RegistraValorFracaoEstacionamentoTest;
import tppe.tp1.RegistraValorHoraCheiaEstacionamentoTest;
import tppe.tp1.RegistraValorMensalistaEstacionamentoTest;

@Suite
@SelectClasses({ RegistraIdEstacionamentoTest.class, RegistraValorFracaoEstacionamentoTest.class,
		RegistraValorHoraCheiaEstacionamentoTest.class, RegistraValorDiariaDiurnaEstacionamentoTest.class,
		RegistraValorDiariaNoturnaEstacionamentoTest.class, RegistraHorarioEntradaDiariaNoturnaTest.class,
		RegistraHorarioSaidaDiariaNoturnaTest.class, RegistraValorMensalistaEstacionamentoTest.class })
@IncludeTags("TesteExcecao")
@SuiteDisplayName("Testes de Excecao")
class TestesExcecaoTest {
}