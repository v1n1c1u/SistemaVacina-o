package situacoes;

import java.time.LocalDate;

import entities.Paciente;

public class TomouPrimDose extends Situacao {
	private LocalDate dataAplicacao;
	private final int MINIMO_DIAS_PARA_SEGUNDA_DOSE = 20;

	public TomouPrimDose(Paciente paciente) {
		this.paciente = paciente;
		this.dataAplicacao = LocalDate.now();
	}

	@Override
	public void mudarSituacao() {
		if(estaHabilitadoParaSegundaDose()) {
			this.paciente.setSituacao(new HabilitadoSegDose(paciente));
		}else {
			System.out.println("PRAZO MÍNIMO DE 20 DIAS NÃO ATINGIDO. MUDANÇA DE SITUAÇÃO NEGADA.");
		}
	}

	private boolean estaHabilitadoParaSegundaDose() {
		LocalDate vinteDiasAtras = LocalDate.now().minusDays(MINIMO_DIAS_PARA_SEGUNDA_DOSE);
		if(getDataAplicacao().isBefore(vinteDiasAtras)) {
			return true;
		}
		return false;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}
	
	public String toString() {
		return "Tomou a primeira dose.";
	}


}
