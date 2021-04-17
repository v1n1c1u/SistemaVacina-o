package situacoes;

import entities.Paciente;

public class HabilitadoSegDose extends Situacao {

	public HabilitadoSegDose(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public void mudarSituacao() {
		this.paciente.setSituacao(new FinalizouVacinacao(paciente));

	}
	public String toString() {
		return "Habilitado para segunda dose.";
	}
}
