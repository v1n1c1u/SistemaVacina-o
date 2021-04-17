package entities;
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaPacientes {
	
	private HashMap<String, Paciente> pacientesCadastrados ;
	private ArrayList<String> profissoesPrivilegiadas;
	private ArrayList<String> comorbidadesPremiadas;
	
	public SistemaPacientes() {
		this.pacientesCadastrados = new HashMap<String, Paciente>();
		this.profissoesPrivilegiadas = new ArrayList<String>();
		this.comorbidadesPremiadas = new ArrayList<String>();
	}

	public void cadastrarPaciente(String[] info, String[] comorbidades) {
		Paciente novoPaciente = new Paciente(info);
		novoPaciente.setComorbidades(comorbidades);
		checarHabilitacaoAutomatica(novoPaciente);
		pacientesCadastrados.put(info[1],novoPaciente);
		
	}

	private void checarHabilitacaoAutomatica(Paciente paciente) {
		if(pacienteTemComorbidadePremiada(paciente) || pacienteTemProfPrivilegiada(paciente)) {
			mudarSituacao(paciente);
		}
		
	}

	private boolean pacienteTemProfPrivilegiada(Paciente paciente) {
		if(profissoesPrivilegiadas.contains(paciente.getProfissao().toUpperCase())){
			return true;
		}
		return false;
	}

	private boolean pacienteTemComorbidadePremiada(Paciente paciente) {
		for(String comorbidade:comorbidadesPremiadas) {
			if(paciente.getComorbidades().contains(comorbidade.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public Paciente getPaciente(String cpfPaciente) {
		if(pacientesCadastrados.containsKey(cpfPaciente)) {
			return pacientesCadastrados.get(cpfPaciente);
		}
		return null;
	}
	public String consultarEMostrarPaciente(String cpfPaciente) {
		String output;
		Paciente pacienteConsultado = getPaciente(cpfPaciente);
		if(pacienteConsultado == null) {
			output = "NÃO HÁ NENHUM PACIENTE COM CPF " + cpfPaciente + ". \n";
		}else {
			output = pacienteConsultado.toString() + "\n";
		}
		return output;
	}
	public void mudarSituacao(Paciente pacienteConsultado) {
		pacienteConsultado.mudarSituacao();
		System.out.println("SITUAÇÃO DO PACIENTE DE CPF "+ pacienteConsultado.getCpf() +" ATUALIZADA. \n");
		
		
	}
	public void addProfissaoPrivilegiada(String profissao) {
		profissoesPrivilegiadas.add(profissao.toUpperCase());
		System.out.println("PROFISSÃO ADICIONADA.");
		for(String cpf : pacientesCadastrados.keySet()) {
			Paciente paciente = pacientesCadastrados.get(cpf);
			checarHabilitacaoAutomatica(paciente);
		}
	}
	
	public void addComorbidadePremiada(String comorbidade) {
		comorbidadesPremiadas.add(comorbidade.toUpperCase());
		System.out.println("COMORBIDADE ADICIONADA.");

		for(String cpf : pacientesCadastrados.keySet()) {
			Paciente paciente = pacientesCadastrados.get(cpf);
			checarHabilitacaoAutomatica(paciente);
		}
	}

	public void imprimirOpcoesAtualizacao() {
		StringBuilder output = new StringBuilder();
		output.append("Atualizar paciente: \n");
		output.append("     1 - Atualizar dados de cadastro; \n");
		output.append("     2 - Mudar situação; \n");
		output.append("     3 - Adicionar comorbidade; \n");
		output.append("     4 - Cancelar; \n");
		output.append("\n");
		System.out.println(output.toString());	
	}

	public void imprimirFormaAtualizacao() {
		StringBuilder forma = new StringBuilder();
		forma.append("Opções de campos a serem atualizados: \n");
		forma.append("     1 - Nome; \n");
		forma.append("     2 - Endereço; \n");
		forma.append("     3 - NumSUS; \n");
		forma.append("     4 - Email; \n");
		forma.append("     5 - Profissão; \n");
		forma.append("     6 - Cancelar; \n");
		forma.append("\n");
		System.out.println(forma.toString());	
	}

	public void addComorbidadePaciente(String novaComorbidade, Paciente pacienteConsultado) {
		pacienteConsultado.addComordidade(novaComorbidade);
		
	}

	public void atualizarPaciente(Paciente pacienteConsultado, int campo, String novoValor) {
		switch(campo) {
		case 1:
			pacienteConsultado.setNome(novoValor);
			break;
		case 2:
			pacienteConsultado.setEndereco(novoValor);
			break;
		case 3:
			pacienteConsultado.setNumSUS(novoValor);
			break;
		case 4:
			pacienteConsultado.setEmail(novoValor);
			break;
		case 5:
			pacienteConsultado.setProfissao(novoValor);
			break;
		case 6:
			break;
		default:
			System.out.println("CAMPO INVÁLIDO.");
			break;
		}
		
	}

}
