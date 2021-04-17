package entities;

import java.util.ArrayList;
import java.util.Arrays;

import situacoes.NaoHabilitado;
import situacoes.Situacao;

public class Paciente {
	private String nome;
	private String cpf;
	private String endereco;
	private String numSUS;
	private String email;
	private String profissao;
	private ArrayList<String> comorbidades;
	private Situacao situacao;
	
	public Paciente(String[] infoPaciente) {
		this.nome = infoPaciente[0];
		this.cpf = infoPaciente[1];
		this.endereco = infoPaciente[2];
		this.numSUS = infoPaciente[3];
		this.email = infoPaciente[4];
		this.profissao = infoPaciente[5];
		this.comorbidades = new ArrayList<String>();
		this.situacao = new NaoHabilitado(this);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumSUS() {
		return numSUS;
	}
	public void setNumSUS(String numSUS) {
		this.numSUS = numSUS;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public ArrayList<String> getComorbidades() {
		return comorbidades;
	}
	public void setComorbidades(String[] comorbidades) {
		this.comorbidades.addAll(Arrays.asList(comorbidades));
	}
	public void addComordidade(String comorbidade) {
		comorbidades.add(comorbidade);
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public void mudarSituacao() {
		situacao.mudarSituacao();
		
	}
	public String toString() {
		StringBuilder descricao = new StringBuilder();
		descricao.append(getNome().toUpperCase() + "\n");
		descricao.append("CPF: "+getCpf() + "\n");
		descricao.append("END: "+ getEndereco().toUpperCase() + "\n");
		descricao.append("Nº SUS: "+ getNumSUS() + "\n");
		descricao.append("Email: "+getEmail().toUpperCase() + "\n");
		descricao.append("Profissão: "+getProfissao().toUpperCase() + "\n");
		descricao.append("Comorbidades: " + getComorbidades().toString() + "\n");
		descricao.append("Situação: " + getSituacao().toString() + "\n");

		return descricao.toString();
	}
}
