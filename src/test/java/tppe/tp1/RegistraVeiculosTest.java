package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import tppe.tp1.veiculo.VeiculoBuilder;

public class RegistraVeiculosTest {

	// Teste de falsificação
	@Test
	void testCadastroVeiculos() {
		VeiculoBuilder cadastroVeiculo = new VeiculoBuilder();
		assertNotNull(cadastroVeiculo);	
	}
}
