package concurso;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.Notificacion;
import interfaces.Registro;

public class Concurso {// El objetivo es cumplir con las consignas asignadas por ende hay atributos que
						// se omiten a fin de reducir el tiempo
	// --- Atributos ---
	private LocalDate iInscripcion;
	private LocalDate fInscripcion;
	private ArrayList<Participante> participantes;
	private String nombre;
	private int idConcurso;
	private Registro registro;
	private Notificacion notificacion;

	public Concurso(String nombre, int codigo, LocalDate fecha, int duracionDelCurso, Registro unRegistro,
			Notificacion notificacion) {
		iInscripcion = fecha;
		fInscripcion = fecha.plusDays(duracionDelCurso);
		this.idConcurso = codigo;
		this.participantes = new ArrayList<Participante>();
		this.nombre = nombre;
		this.registro = unRegistro;
		this.notificacion = notificacion;

	}

	// --- Metodos ---
	public boolean inscribirParticipante(Participante unParticipante) {
		if (!estaInscripto(unParticipante.nombre()) && sePuedeInscribir()) {
			if (esPrimerDia())
				unParticipante.sumarPuntos();
			this.participantes.add(unParticipante);// Se inscribe el participante
			this.registro.registrarParticipante(unParticipante, this);// objeto que use la interface registro
			notificacion.enviarNotificacion();
		} else
			throw new RuntimeException("no se puede inscribir");
		return true;
	}

	private boolean sePuedeInscribir() {
		return LocalDate.now().isBefore(fInscripcion) && LocalDate.now().isAfter(iInscripcion.minusDays(1));
	}// Le resto un dia para simular un mayor o igual

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

	public int id() {
		// TODO Auto-generated method stub
		return this.idConcurso;
	}

}
