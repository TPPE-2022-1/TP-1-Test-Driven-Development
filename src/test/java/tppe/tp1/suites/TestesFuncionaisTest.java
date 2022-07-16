package tppe.tp1.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import tppe.tp1.CriaEstacionamentoParametrosInvalidosTest;
import tppe.tp1.CriaEstacionamentoTest;
import tppe.tp1.RegistraCapacidadeTest;
import tppe.tp1.RegistraHorarioAberturaTest;
import tppe.tp1.RegistraHorarioEncerramentoTest;
import tppe.tp1.RegistraHorarioEntradaDiariaNoturnaTest;
import tppe.tp1.RegistraHorarioSaidaDiariaNoturnaTest;
import tppe.tp1.RegistraIdEstacionamentoTest;
import tppe.tp1.RegistraValorDiariaDiurnaEstacionamentoTest;
import tppe.tp1.RegistraValorDiariaNoturnaEstacionamentoTest;
import tppe.tp1.RegistraValorEventoEstacionamentoTest;
import tppe.tp1.RegistraValorFracaoEstacionamentoTest;
import tppe.tp1.RegistraValorHoraCheiaEstacionamentoTest;
import tppe.tp1.RegistraValorMensalistaEstacionamentoTest;
import tppe.tp1.RegistraValorRetornoContratanteEstacionamentoTest;

@Suite
@SelectClasses({ RegistraIdEstacionamentoTest.class, RegistraValorFracaoEstacionamentoTest.class,
		RegistraValorHoraCheiaEstacionamentoTest.class, RegistraValorDiariaDiurnaEstacionamentoTest.class,
		RegistraValorDiariaNoturnaEstacionamentoTest.class, RegistraHorarioEntradaDiariaNoturnaTest.class,
		RegistraHorarioSaidaDiariaNoturnaTest.class, RegistraValorMensalistaEstacionamentoTest.class,
		RegistraValorEventoEstacionamentoTest.class, RegistraHorarioAberturaTest.class,
		RegistraHorarioEncerramentoTest.class, RegistraCapacidadeTest.class,
		RegistraValorRetornoContratanteEstacionamentoTest.class, CriaEstacionamentoTest.class,
		CriaEstacionamentoParametrosInvalidosTest.class })
@IncludeTags("TesteFuncional")
@SuiteDisplayName("Testes Funcionais")
public class TestesFuncionaisTest {
}
