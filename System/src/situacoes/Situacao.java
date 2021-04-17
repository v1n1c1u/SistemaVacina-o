package situacoes;

import entities.Paciente;

public abstract class Situacao {
	protected Paciente paciente;
	
	public abstract void mudarSituacao();
}
