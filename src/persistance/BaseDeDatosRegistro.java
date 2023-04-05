package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mysql.jdbc.Statement;

import concurso.Concurso;
import concurso.Participante;
import interfaces.Registro;

public class BaseDeDatosRegistro implements Registro {
	private String url;// "jdbc:mysql://localhost:3306/objetos2"
	private String usuario;// "root"
	private String contraseña;// ""
	private Connection miConexion = null;

	public BaseDeDatosRegistro(String url, String user, String pass) {
		this.url = url;
		this.usuario = user;
		this.contraseña = pass;
	}

	@Override
	public boolean registrarParticipante(Participante participante, Concurso concurso) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			miConexion = DriverManager.getConnection(url, usuario, contraseña);
			Statement sent = (Statement) miConexion.createStatement();

			sent.executeUpdate("insert into concursos(fecha, id_participante, id_concurso) " + "values(" + fechaActual()
					+ ", " + participante.id() + " ," + concurso.id() + ")");

			sent.close();
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean registrarVenta(double importe) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			miConexion = DriverManager.getConnection(url, usuario, contraseña);
			Statement sent = (Statement) miConexion.createStatement();
			sent.executeUpdate(
					"insert into ventas(fecha, monto_total) " + "values(" + fechaActual() + ", " + importe + ")");

			sent.close();
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	private String fechaActual() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Definir el formato deseado

		String fecha = LocalDate.now().format(formato);
		return fecha;
	}

}
