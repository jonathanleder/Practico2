package concurso;

public class Participante {
	// --- Atributos ---
	private String nombre;
	private int dni;
	private int puntos;

	// --- Constructor/es ---

	public Participante(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.puntos = 0;
	}

	// --- Metodos ---

	public void sumarPuntos() {
		this.puntos += 10;
	}

	public int getPuntaje() {
		return this.puntos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String info() {
		return "Nombre:" + this.nombre + "\nDNI:" + this.dni + "\nPuntaje total:" + this.getPuntaje() + "\n\n";
	}

}
