package persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Statement;

import concurso.Participante;

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
	public double registrarVenta(Double importe) {
		// TODO Auto-generated method stub
		String total = LocalDate.now() + " || " + String.valueOf(importe);
		try {
			Files.write(Paths.get(ruta), total.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return importe;
	}

	@Override
	public void registrarParticipanteBd(Participante participante, int concurso) {
		Connection miConexion = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/objetos2", "root", "");
			Statement sent = (Statement) miConexion.createStatement();
			int cant = sent.executeUpdate("insert into concursos(fecha, id_participante, id_concurso) " + "values("
					+ LocalDate.now().toString() + ", " + participante.id() + " ," + concurso + ")");

			if (cant == 1) {
				System.out.println("Se registro correctamente");
			}
			sent.close();
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}

	}

	@Override
	public void registrarVentaBd(double importe) {
		// TODO Auto-generated method stub

	}

}
