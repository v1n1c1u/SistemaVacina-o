package situacoes;

import entities.Paciente;

public class HabilitadoPrimDose extends Situacao {

	public HabilitadoPrimDose(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public void mudarSituacao() {
		this.paciente.setSituacao(new TomouPrimDose(paciente));

	}
	public String toString() {
		return "Habilitado para tomar a primeira dose.";
	}
}
