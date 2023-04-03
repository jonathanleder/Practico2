package interfaces;

import concurso.Concurso;
import concurso.Participante;

public interface Registro {

	public abstract boolean registrarParticipante(Participante inscripto, Concurso concurso);

	public abstract boolean registrarVenta(double importe);

}
