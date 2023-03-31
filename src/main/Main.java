package main;

import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;
import persistance.BaseDeDatosRegistro;
import persistance.DiscoRegistro;
import tarjetas.Bebida;
import tarjetas.DispositivoElectronico;
import tarjetas.Pedido;
import tarjetas.Plato;
import tarjetas.TarjetaComarcaPlus;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Prueba de la tarjeta
		// Creacion de comidas y pedido
		Plato ravioles = new Plato("Ravioles con tuco", 500);
		Bebida gaseosa = new Bebida("Fanta", 300);
		Pedido miPedido = new Pedido(ravioles, gaseosa);
		// Creacion de disco local
		String direccion = "C:\\\\\\\\Users\\\\\\\\jonyl\\\\\\\\Desktop\\\\\\\\registro_ventas.txt";
		DiscoRegistro disco = new DiscoRegistro(direccion);

		// Creacion de base de datos
		String url = "jdbc:mysql://localhost:3306/objetos2";
		String user = "root";
		String pass = "";
		BaseDeDatosRegistro baseDeDatos = new BaseDeDatosRegistro(url, user, pass);

		TarjetaComarcaPlus comarca = new TarjetaComarcaPlus("Jonathan Leder", 456123789, 850);
		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido, baseDeDatos);
		miDispositivo.calcularCostoTotal(comarca, 5);

		// Prueba de los concursos

		int duracionDelCurso = 10;

		Concurso java = new Concurso("java", 1234, LocalDate.now(), duracionDelCurso, baseDeDatos);
		java.inscribirParticipante(new Participante("Juna", 52));
		java.inscribirParticipante(new Participante("Jona", 39));

	}

}
