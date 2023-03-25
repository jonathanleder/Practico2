package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/objetos2";

	public Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/objetos2", "root", "");
			System.out.println("conexion ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		return conexion;
	}

	// TODO Auto-generated constructor stub
	public static void main(String[] args) {

	}
}
