package concurso;

public class Participante {
	// --- Atributos ---
	private String nombre;
	private int idParticipante;
	private int puntos;

	// --- Constructor/es ---

	public Participante(String nombre, int idParticipante) {
		this.nombre = nombre;
		this.idParticipante = idParticipante;
		this.puntos = 0;
	}

	// --- Metodos ---

	public void sumarPuntos() {
		this.puntos += 10;
	}

	public int puntaje() {
		return this.puntos;
	}

	public int id() {
		return this.idParticipante;
	}

	public String nombre() {
		return this.nombre;
	}

	public String info() {
		return "Nombre:" + this.nombre + "\nPuntaje total:" + this.puntaje() + "\n\n";
	}

}
