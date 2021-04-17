package main;


import java.util.Scanner;

import entities.Paciente;
import entities.SistemaPacientes;

public class Main {
	static Scanner input = new Scanner(System.in);
	static SistemaPacientes sistema = new SistemaPacientes();


	public static void main(String[] args) {
		run();
	}

	private static void run() {
		int opcao = 0;
		boolean sistemaAberto = true;
		while(sistemaAberto) {
			printOpcoesPrincipais();
			System.out.print("Opção:");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
			case 1:
				opcaoCadastrarPaciente();	
				break;
			case 2:
				opcaoAtualizarPaciente();
				break;
			case 3:
				opcaoMostrarPaciente();
				break;
			case 4:
				opcaoAdicionarProfissaoPrivilegiada();
				break;
			case 5:
				opcaoAdicionarComorbidadePremiada();
				break;
			case 6:
				sistemaAberto = false;
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA.");
				break;
			}
		}
		System.out.println("ATÉ MAIS!");
		System.exit(0);			
	}

	private static void opcaoAdicionarComorbidadePremiada() {
		System.out.print("Comorbidade a ser habilitada:");
		String novaComorbidade = input.nextLine();
		sistema.addComorbidadePremiada(novaComorbidade.toUpperCase());
	}

	private static void opcaoAdicionarProfissaoPrivilegiada() {
		System.out.print("Profissão a ser habilitada:");
		String novaProfissao = input.nextLine();
		sistema.addProfissaoPrivilegiada(novaProfissao.toUpperCase());
	}

	private static void opcaoMostrarPaciente() {
		System.out.print("CPF do paciente:");
		String cpfPaciente = input.nextLine();
		System.out.println("----------------------------------");
		System.out.println(sistema.consultarEMostrarPaciente(cpfPaciente));
		System.out.println("----------------------------------");
	}

	

	private static void opcaoAtualizarPaciente() {
		System.out.print("CPF do paciente:");
		String cpfPaciente = input.nextLine();
		Paciente pacienteConsultado = sistema.getPaciente(cpfPaciente);
		if(pacienteConsultado == null) {
			System.out.println("NÃO HÁ NENHUM PACIENTE COM CPF " + cpfPaciente + ". \n");
		}else {
			sistema.imprimirOpcoesAtualizacao();
			System.out.print("Opção: ");
			int opcaoAtualizacao = input.nextInt();
			input.nextLine();
			switch(opcaoAtualizacao) {
			case 1:
				sistema.imprimirFormaAtualizacao();
				System.out.print("Número do campo:");
				int campo = input.nextInt();
				input.nextLine();
				System.out.print("Novo valor:");
				String novoValor = input.nextLine();
				sistema.atualizarPaciente(pacienteConsultado, campo, novoValor);
				System.out.println(pacienteConsultado.toString() + "\n");
				break;
			case 2:
				sistema.mudarSituacao(pacienteConsultado);
				System.out.println(pacienteConsultado.toString() + "\n");
				break;
			case 3:
				System.out.print("Nova comorbidade: ");
				String novaComorbidade = input.nextLine().toUpperCase();
				sistema.addComorbidadePaciente(novaComorbidade, pacienteConsultado);
				System.out.println("COMORBIDADE ADICIONADA.");
				break;
			case 4:
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA.");

				break;
			}
		}
	}

	private static void opcaoCadastrarPaciente() {
		String[] infoPaciente = new String[6];
		int index = 0;
		System.out.print("Nome: ");
		infoPaciente[index] = input.nextLine();
		index++;
		System.out.print("CPF: ");
		infoPaciente[index] = input.nextLine();
		index++;
		System.out.print("Endereço: ");
		infoPaciente[index] = input.nextLine();
		index++;
		System.out.print("Número SUS: ");
		infoPaciente[index] = input.nextLine();
		index++;
		System.out.print("Email: ");
		infoPaciente[index] = input.nextLine();
		index++;
		System.out.print("Profissão: ");
		infoPaciente[index] = input.nextLine().toUpperCase();
		
		System.out.println("Comorbidades: (Separe por vírgula sem espaço)");
		String[] comorbidades = input.nextLine().split(",");
		sistema.cadastrarPaciente(infoPaciente, comorbidades);	
		
		System.out.println("PACIENTE CADASTRADO. \n");
	}

	private static void printOpcoesPrincipais() {
		StringBuilder opcoesPrincipais = new StringBuilder();
		opcoesPrincipais.append("     SISTEMA DE PACIENTES \n");
		opcoesPrincipais.append("============================== \n");
		opcoesPrincipais.append("Opções de operação: \n");
		opcoesPrincipais.append("1 - Cadastrar paciente; \n"
							+ "2 - Atualizar paciente; \n"
							+ "3 - Mostrar paciente; \n"
							+ "4 - Adicionar profissão a ser habilitada; \n"
							+ "5 - Adicionar comorbidade a ser habilitada; \n"
							+ "6 - Sair; \n");
		System.out.println(opcoesPrincipais.toString());
	}
}
