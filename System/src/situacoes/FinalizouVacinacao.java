package situacoes;

import entities.Paciente;

public class FinalizouVacinacao extends Situacao {

	public FinalizouVacinacao(Paciente paciente) {
		this.paciente = paciente;

	}

	@Override
	public void mudarSituacao() {}
	
	public String toString() {
		return "Finalizou vacinação";
	}

}
