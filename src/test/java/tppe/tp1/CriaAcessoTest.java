package tppe.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;

public class CriaAcessoTest {

	
	@ParameterizedTest
	@MethodSource("criaAcessos")
	@Tag("TesteFuncional")
	void testCriaAcesso(String placa, String entrada, String saida) {
		AcessoBuilder acessoBuilder = new AcessoBuilder();

		LocalTime horaEntrada = LocalTime.parse(entrada);
		LocalTime horaSaida = LocalTime.parse(saida);

		acessoBuilder.setPlaca(placa);
		acessoBuilder.setHoraEntrada(horaEntrada);
		acessoBuilder.setHoraSaida(horaSaida);

		Acesso acesso = acessoBuilder.build();
		
		assertEquals(placa, acesso.getPlaca());
		assertEquals(horaEntrada, acesso.getHoraEntrada());
		assertEquals(horaSaida, acesso.getHoraSaida());
	}
	
	static Stream<Arguments> criaAcessos() {
		return Stream.of(
					Arguments.of("JHD9698", "22:40", "23:30"),
					Arguments.of("JGQ4642", "12:40", "18:00"),
					Arguments.of("JGF6820", "10:30", "22:00")
				);
	}




}
