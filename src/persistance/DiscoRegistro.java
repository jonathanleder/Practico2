package persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;
import interfaces.Registro;

public class DiscoRegistro implements Registro {

	private String ruta;

	public DiscoRegistro(String direccion) {
		this.ruta = direccion;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean registrarParticipante(Participante inscripto, Concurso concurso) {

		try {
			Files.write(Paths.get(ruta), registro(inscripto, concurso).getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	private String registro(Participante unParticipante, Concurso concurso) {
		return LocalDate.now() + "||" + unParticipante.id() + "||" + concurso.id() + "\n";
	}

	@Override
	public boolean registrarVenta(double importe) {
		// TODO Auto-generated method stub
		String total = LocalDate.now() + " || " + String.valueOf(importe);
		try {
			Files.write(Paths.get(ruta), total.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

}
