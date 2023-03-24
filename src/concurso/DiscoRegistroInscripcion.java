package concurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DiscoRegistroInscripcion implements RegistroInscripcion {

	private String ruta;

	public DiscoRegistroInscripcion(String direccion) {
		this.ruta = direccion;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrarParticipante(String inscripto) {

		try {
			Files.write(Paths.get(ruta), inscripto.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub

	}

}
