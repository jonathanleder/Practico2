package main;

import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;
import interfaces.Notificacion;
import persistance.BaseDeDatosRegistro;
import persistance.DiscoRegistro;
import persistance.EmailNotificacion;
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

		DiscoRegistro disco = new DiscoRegistro(
				"C:\\\\\\\\Users\\\\\\\\jonyl\\\\\\\\Desktop\\\\\\\\registro_ventas.txt");

		// Creacion de base de datos

		BaseDeDatosRegistro baseDeDatos = new BaseDeDatosRegistro("jdbc:mysql://localhost:3306/objetos2", "root", "");

		// Creacion de tipo notificacion
		Notificacion email = new EmailNotificacion("inscripcioaconcursos@example.com",
				"Inscripcion al concurso elegido ", "su solicitud fue aprobada");

		// Prueba Tarjetas

		TarjetaComarcaPlus comarca = new TarjetaComarcaPlus("Jonathan Leder", 456123789, 850);
		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido, baseDeDatos);
		miDispositivo.calcularCostoTotal(comarca, 5);

		// Prueba de los concursos

		int duracionDelCurso = 10;

		Concurso java = new Concurso("java", 199, LocalDate.now(), duracionDelCurso, baseDeDatos, email);
		java.inscribirParticipante(new Participante("Juan", 98));
		java.inscribirParticipante(new Participante("Jonathan", 56));

	}

}
