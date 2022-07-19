package tppe.tp1.app;

//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class AppMain {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
		EstacionamentoBuilder e = new EstacionamentoBuilder();
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
		estacionamentos.add(e.build());
		
		e = new EstacionamentoBuilder();
		e.setId(1);
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
		estacionamentos.add(e.build());
	
		AcessoBuilder acessoBuilder = new AcessoBuilder();
		acessoBuilder.setPlaca("GHJ7653");
		acessoBuilder.setHoraEntrada(LocalDateTime.parse("2022-07-17T12:40"));
		acessoBuilder.setHoraSaida(LocalDateTime.parse("2022-07-17T15:30"));
		acessoBuilder.setValorAcesso(50.00);
		acessoBuilder.setValorContratante(100.00);
		estacionamentos.get(0).addAcesso(acessoBuilder.build());
		
		Integer opcoes = 0;
		
		
		while (opcoes!=6) {
			System.out.println("Escolha uma das opcoes:\n"
					+ "[1] - Cadastrar novo Estacionameno.\n" //feito
					+ "[2] - Registrar novo acesso.\n" //feito mas horario de entrada ruim
					+ "[3] - Verificar informacoes de um acesso.\n" //feito
					+ "[4] - Verificar valor total de repasse para o contratante de um estacionamento.\n" //feito
					+ "[5] - Verificar todos estacionamentos cadastrados\n" //feito
					+ "[6] - Encerrar aplicao.\n"); //feito
			opcoes = input.nextInt();
			switch(opcoes) {
			case 1:
				limpaTela();
				estacionamentos.add(novoEstacionamento());
				break;
			case 2:
				limpaTela();
				if (estacionamentos.size() == 0) {
					System.out.println("Voce precisa primeiro cadastrar um estacionamento.\n"
							+ "Deseja cadastrar um estacionamento? (s/n): ");
					if (input.next().equalsIgnoreCase("s"));
						estacionamentos.add(novoEstacionamento());
				} else if (estacionamentos.size() == 1) {
					registraAcesso(estacionamentos.get(0));
				} else {
					System.out.println("Digite o id do estacionamento desejado: ");
					registraAcesso(estacionamentos.get(input.nextInt()));
				}
				break;
			case 3:
				limpaTela();
				System.out.println("Insira o Id do estacionamento: ");
				buscaAcessos(estacionamentos.get(input.nextInt()));
				break;
			case 4:
				limpaTela();
				Double soma = 0.0;
				System.out.println("Insira o Id do estacionamento: ");
				for (Acesso acesso : estacionamentos.get(input.nextInt()).getListaAcessos())
				{
					//sum valorContratante
					soma += acesso.getValorContratante();
					
				}
				System.out.println("Valor total de repasse: " + soma);
				break;
			case 5:
				limpaTela();
				System.out.println("LISTA DE ESTACIONAMENTOS:\n");
				for (Estacionamento estacionamento : estacionamentos) {
					System.out.println("id: "+estacionamento.getId()+"\n"
					+ "valor da fracao: "+estacionamento.getValorFracao()+"\n"
					+ "desconto da hora cheia: "+estacionamento.getDescontoHoraCheia()+"\n"
					+ "valor da diaria diurna: "+estacionamento.getValorDiariaDiurna()+"\n"
					+ "desconto da diaria noturna: "+estacionamento.getDescontoDiariaNoturna()+"\n"
					+ "horario de entrada da diaria noturna: "+estacionamento.getHorarioEntradaDiariaNoturna()+"\n"
					+ "horario de saida da diaria noturna: "+estacionamento.getHorarioSaidaDiariaNoturna()+"\n"
					+ "valor da mensalidade: "+estacionamento.getValorMensalidade()+"\n"
					+ "valor do evento: "+estacionamento.getValorEvento()+"\n"
					+ "horario de abertura: "+estacionamento.getHorarioAbertura()+"\n"
					+ "horario de encerramento: "+estacionamento.getHorarioEncerramento()+"\n"
					+ "capacidade: "+estacionamento.getCapacidade()+"\n"
					+ "retorno do contratante: "+estacionamento.getRetornoContratante()+"\n"
					+ "-------------------------------------------------------------------------------------------------\n\n"
					);
				}
				
				System.out.println("Deseja continuar ?(s/n)");
				if(input.next().equalsIgnoreCase("n"))
					opcoes = 6;
				break;
			case 6:
				break;
			default:
				System.out.println("Escolha invalida!\n\n");
			}
		}
		
		System.out.println("Programa Encerrado com Sucesso!");
	}
	
	public static void registraAcesso(Estacionamento estacionamento) throws Exception {
		AcessoBuilder acesso = new AcessoBuilder();
		
		System.out.println("Digite a placa do carro(7 caracteres): ");
		acesso.setPlaca(input.next());
		System.out.println("Digite o horario de entrada do veiculo(aaaa-mm-ddThh:mm): ");
		acesso.setHoraEntrada(LocalDateTime.parse(input.next()));
		System.out.println("Digite o horario de saida do veiculo(aaaa-mm-ddThh:mm): ");
		acesso.setHoraSaida(LocalDateTime.parse(input.next()));
		System.out.println("O acesso e acesso especial(s/n): ");
		if (input.next().equalsIgnoreCase("s")) {
			System.out.println("Digite o tipo de acesso do veiculo(Mensalista/Evento): ");
			acesso.setTipoAcesso(input.next());
		}
		Acesso acessoCadastro = acesso.build();
		acessoCadastro.setValorAcesso(estacionamento.calculaValorTotal(acessoCadastro));
		acessoCadastro.setValorContratante((estacionamento.getRetornoContratante()*acessoCadastro.getValorAcesso())/100);
		estacionamento.addAcesso(acessoCadastro);
		System.out.println("Registro efetuado com sucesso.");
	}

	public static Estacionamento novoEstacionamento() throws Exception {
		EstacionamentoBuilder estacionamento = new EstacionamentoBuilder();
		
		System.out.println("Insira os dados do estacionamento:\nID: ");
		estacionamento.setId(input.nextInt());
		System.out.println("Valor cobrado por fração de 15min: ");
		estacionamento.setValorFracao(input.nextDouble());
		System.out.println("Desconto da hora cheia: ");
		estacionamento.setDescontoHoraCheia(input.nextDouble());
		System.out.println("Valor da diaria diurna: ");
		estacionamento.setValorDiariaDiurna(input.nextDouble());
		System.out.println("Desconto da diaria noturna (0<= x <=100): ");
		estacionamento.setDescontoDiariaNoturna(input.nextDouble());
		System.out.println("Inicio do horário noturno(formato dd/mm/aa hh:mm): ");
		estacionamento.setHorarioEntradaDiariaNoturna(LocalTime.parse(input.next()));
		System.out.println("Fim do horário noturno(formato dd/mm/aa hh:mm): ");
		estacionamento.setHorarioSaidaDiariaNoturna(LocalTime.parse(input.next()));
		System.out.println("Valor cobrado por mensalidade: ");
		estacionamento.setValorMensalidade(input.nextDouble());
		System.out.println("Valor cobrado por evento: ");
		estacionamento.setValorEvento(input.nextDouble());
		System.out.println("Horario de abertura do estacionamento(formato dd/mm/aa hh:mm): ");
		estacionamento.setHorarioAbertura(LocalTime.parse(input.next()));
		System.out.println("Horario fechamento(formato dd/mm/aa hh:mm): ");
		estacionamento.setHorarioEncerramento(LocalTime.parse(input.next()));
		System.out.println("Capacidade do estacionamento: ");
		estacionamento.setCapacidade(input.nextInt());

		System.out.println("Registro efetuado com sucesso.");
		return estacionamento.build();
	}
	
	public static void buscaAcessos(Estacionamento estacionamento) {
		String placa;
		Boolean opcao = true;
		while(opcao) {
			System.out.println("Insira a placa do veiculo: ");
			placa = input.next().trim();

			for (Acesso acesso : estacionamento.getListaAcessos()) {

				if (acesso.getPlaca().equalsIgnoreCase(placa)) {
					// print all info about the access
					System.out.println("placa: "+acesso.getPlaca()+"\n"
					+ "Horario de entrada: "+acesso.getHoraEntrada()+"\n"
					+ "Horario de saida: "+acesso.getHoraSaida()+"\n"
					+ "Valor de acesso: "+acesso.getValorAcesso()+"\n"
					+ "Valor do contratante: "+acesso.getValorContratante()+"\n"
					);
				}
			}
		

			// wait for enter to go to menu
			System.out.println("Deseja continuar ?(s/n)");
			if(input.next().equalsIgnoreCase("n"))
				opcao = false;
					
		}
	}

	public static void limpaTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}
}
