package main;

import java.time.LocalDate;

import concurso.Concurso;
import concurso.Participante;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Prueba de la tarjeta
//		Plato ravioles = new Plato("Ravioles con tuco", 500);
//		Bebida gaseosa = new Bebida("Fanta", 300);
//		String direccion = "C:\\\\\\\\Users\\\\\\\\jonyl\\\\\\\\Desktop\\\\\\\\registro_ventas.txt";
//		Pedido miPedido = new Pedido(ravioles, gaseosa);
//		TarjetaComarcaPlus comarca = new TarjetaComarcaPlus("Jonathan Leder", 456123789, 850);
//
//		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido, direccion);

		// Prueba de los concursos

		int duracionDelCurso = 10;
		String ruta = "C:\\\\Users\\\\jonyl\\\\Desktop\\\\registro_participantes.txt";
		Concurso java = new Concurso("java", 1234, LocalDate.now(), duracionDelCurso, ruta);
		java.inscribirParticipante(new Participante("Juan", 52));
		java.inscribirParticipante(new Participante("Jonathan", 39));

	}

}
