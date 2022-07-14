package tppe.tp1;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({ RegistraIdEstacionamentoTest.class, RegistraValorFracaoEstacionamentoTest.class, RegistraValorHoraCheiaEstacionamentoTest.class })
@IncludeTags("TesteFuncional")
@SuiteDisplayName("Testes Funcionais")
public class TestesFuncionaisTest {
}
