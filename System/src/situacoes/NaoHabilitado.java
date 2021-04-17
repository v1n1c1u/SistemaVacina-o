package situacoes;

import entities.Paciente;

public class NaoHabilitado extends Situacao {

	public NaoHabilitado(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public void mudarSituacao() {
		this.paciente.setSituacao(new HabilitadoPrimDose(paciente));
		
	}
	public String toString() {
		return "Não habilitado.";
	}
}
