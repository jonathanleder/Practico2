package persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class DiscoRegistro implements Registro {

	private String ruta;

	public DiscoRegistro(String direccion) {
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

	@Override
	public void registrarVenta(Double importe) {
		// TODO Auto-generated method stub
		String total = LocalDate.now() + " || " + String.valueOf(importe);
		try {
			Files.write(Paths.get(ruta), total.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
