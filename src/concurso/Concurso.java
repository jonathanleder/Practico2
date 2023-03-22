package concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {// El objetivo es cumplir con las consignas asignadas por ende hay atributos que
						// se omiten a fin de reducir el tiempo
	// --- Atributos ---
	LocalDate iInscripcion;
	LocalDate fInscripcion;
	ArrayList<Participante> participantes;
	String nombre;

	public Concurso(String nombre, int puntos, int codigo) {
		// La fecha de inscripcion se crea al crear un curso y su fecha de finalizacion
		// es a sus 10 dias posteriores
		iInscripcion = LocalDate.now();
		fInscripcion = LocalDate.now().plusDays(10);
		this.participantes = new ArrayList<Participante>();
		this.nombre = nombre;

	}

	public Concurso(String nombre, int puntos, int codigo, LocalDate fecha, int duracionDelCurso) {
		iInscripcion = fecha;
		fInscripcion = fecha.plusDays(duracionDelCurso);
		this.participantes = new ArrayList<Participante>();
		this.nombre = nombre;

	}

	// --- Metodos ---
	public void inscribirParticipante(Participante unParticipante) {
		if (!estaInscripto(unParticipante) && sePuedeInscribir()) {// Cambiar los syso por excepciones
			if (esPrimerDia())
				unParticipante.sumarPuntos();
			this.participantes.add(unParticipante);// Se inscribe el participante
		}
	}

	private boolean sePuedeInscribir() {
		return LocalDate.now().isBefore(fInscripcion) && LocalDate.now().isAfter(iInscripcion.minusDays(1));
	}// Le resto un dia para simular un mayor o igual

	public boolean estaInscripto(Participante participante) {
		return this.participantes.stream().anyMatch(p -> participante.equals(participante));
	}

	private boolean esPrimerDia() {
		return LocalDate.now().isEqual(iInscripcion);
	}

	public ArrayList mostrarParticipantes() {
		if (this.participantes.isEmpty())
			throw new RuntimeException("No hay Participantes inscriptos");// Poner excepcion
		else {
			return this.participantes;
		}
	}
}
