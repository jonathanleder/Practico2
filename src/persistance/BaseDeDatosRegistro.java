package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Statement;

import concurso.Concurso;
import concurso.Participante;
import interfaces.Registro;

public class BaseDeDatosRegistro implements Registro {
	private String url;// Deberia ser: "jdbc:mysql://localhost:3306/objetos2", "root", ""
	private String usuario;// "root"
	private String contraseña;// ""
	private Connection miConexion = null;

	public BaseDeDatosRegistro(String url, String user, String pass) {
		this.url = url;
		this.usuario = user;
		this.contraseña = pass;
	}

	@Override
	public void registrarParticipante(Participante participante, Concurso concurso) {

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			miConexion = DriverManager.getConnection(url, usuario, contraseña);
			Statement sent = (Statement) miConexion.createStatement();
			int cant = sent.executeUpdate("insert into concursos(fecha, id_participante, id_concurso) " + "values("
					+ LocalDate.now() + ", " + participante.id() + " ," + concurso.id() + ")");

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
	public boolean registrarVenta(double importe) {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			miConexion = DriverManager.getConnection(url, usuario, contraseña);
			Statement sent = (Statement) miConexion.createStatement();
			int cant = sent.executeUpdate("insert into ventas(fecha, monto_total) " + "values("
					+ LocalDate.now().toString() + ", " + importe + ")");

			if (cant == 1) {
				System.out.println("Se registro correctamente");
			}
			sent.close();
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		return true;
	}

}
