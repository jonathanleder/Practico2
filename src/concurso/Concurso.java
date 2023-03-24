package concurso;

import java.time.LocalDate;
import java.util.ArrayList;

import persistance.DiscoRegistro;

public class Concurso {// El objetivo es cumplir con las consignas asignadas por ende hay atributos que
						// se omiten a fin de reducir el tiempo
	// --- Atributos ---
	private LocalDate iInscripcion;
	private LocalDate fInscripcion;
	ArrayList<Participante> participantes;
	private String nombre;
	private int idConcurso;
	private DiscoRegistro enDisco;

	public Concurso(String nombre, int codigo, LocalDate fecha, int duracionDelCurso, String ruta) {
		iInscripcion = fecha;
		fInscripcion = fecha.plusDays(duracionDelCurso);
		this.idConcurso = codigo;
		this.participantes = new ArrayList<Participante>();
		this.nombre = nombre;
		this.enDisco = new DiscoRegistro(ruta);

	}

	// --- Metodos ---
	public void inscribirParticipante(Participante unParticipante) {
		if (!estaInscripto(unParticipante.nombre()) && sePuedeInscribir()) {// Cambiar los syso por excepciones
			if (esPrimerDia())
				unParticipante.sumarPuntos();
			this.participantes.add(unParticipante);// Se inscribe el participante
			this.enDisco.registrarParticipante(registro(unParticipante));
		} else
			throw new RuntimeException("no se puede inscribir");

	}

	private String registro(Participante unParticipante) {
		return LocalDate.now() + "||" + unParticipante.id() + "||" + this.idConcurso + "\n";
	}

	private boolean sePuedeInscribir() {
		return LocalDate.now().isBefore(fInscripcion) && LocalDate.now().isAfter(iInscripcion.minusDays(1));
	}// Le resto un dia para simular un mayor o igual

//	public boolean estaInscripto(Participante participante) { se compara por objeto
//		return this.participantes.contains(participante);
//	}
	public boolean estaInscripto(String nombreParticipante) {// Se compara por nombre
		for (Participante participante : this.participantes) {
			if (participante.nombre().equals(nombreParticipante)) {
				return true;
			}
		}
		return false;
	}

	private boolean esPrimerDia() {
		return LocalDate.now().isEqual(iInscripcion);
	}

	public ArrayList mostrarParticipantes() {
		if (this.participantes.isEmpty())
			throw new RuntimeException("No hay Participantes inscriptos");
		else {
			return this.participantes;
		}
	}
}
