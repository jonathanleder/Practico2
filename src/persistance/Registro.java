package persistance;

import concurso.Participante;

public interface Registro {

	public void registrarParticipante(String inscripto);

	public double registrarVenta(Double importe);

	public void registrarParticipanteBd(Participante participante, int concurso);

	public void registrarVentaBd(double importe);
}
