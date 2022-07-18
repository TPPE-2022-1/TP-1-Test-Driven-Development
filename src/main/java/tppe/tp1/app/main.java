package tppe.tp1.app;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tppe.tp1.acesso.Acesso;
import tppe.tp1.acesso.AcessoBuilder;
import tppe.tp1.estacionamento.Estacionamento;
import tppe.tp1.estacionamento.EstacionamentoBuilder;

public class main {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
		Integer opcoes = 0;
		
		
		while (opcoes != 5) {
			limpaTela();
			System.out.println("Escolha uma das opcoes:\n"
					+ "[1] - Cadastrar novo Estacionameno.\n"
					+ "[2] - Registrar novo acesso.\n"
					+ "[3] - Verificar informacoes de um acesso.\n"
					+ "[4] - Verificar valor total de repasse para o contratante de um estacionamento.\n"
					+ "[5] - Encerrar aplicao.\n");
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
				break;
			default:
					
			}
		}
		
		
	}
	
	public static void registraAcesso(Estacionamento estacionamento) throws Exception {
		AcessoBuilder acesso = new AcessoBuilder();
		
		System.out.println("Digite a placa do carro(7 caracteres): ");
		acesso.setPlaca(input.next());
		System.out.println("Digite o horario de entrada do veiculo(dd/mm/aaaa hh:mm): ");
		acesso.setHoraEntrada(LocalTime.parse(input.next()));
		System.out.println("Digite o horario de saida do veiculo(dd/mm/aaaa hh:mm): ");
		acesso.setHoraSaida(LocalTime.parse(input.next()));
		System.out.println("O acesso e acesso especial(s/n): ");
		if (input.next().equalsIgnoreCase("s")) {
			System.out.println("Digite o tipo de acesso do veiculo(Mensalista/Evento): ");
			acesso.setTipoAcesso(input.next());
		}
			
		estacionamento.addAcesso(acesso.build());
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
		System.out.println("Desconto da diaria noturna: ");
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
		System.out.println("Insira a placa do veiculo: ");
		placa = input.nextLine().trim();
		
		for (Acesso acesso : estacionamento.getListaAcessos()) {
			if (acesso.getPlaca() == placa) {
				System.out.println("Placa");
			}
		}
		
	}

	public static void limpaTela() {
		for (int i = 0; i < 30; i++)
			System.out.println();
	}
}
