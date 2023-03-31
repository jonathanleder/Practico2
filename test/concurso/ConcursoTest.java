package concurso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import persistance.BaseDeDatosRegistro;
import persistance.DiscoRegistro;

class ConcursoTest {

	@Test
	void testInscribirParticipantePrimerDia() {

		int duracionDelCurso = 10;
		String direccion = "C:\\\\Users\\\\jonyl\\\\Desktop\\\\registro_participantes.txt";// en vez de un String
																							// deberia ingresar un
																							// objeto que implementa la
																							// interface registro
		DiscoRegistro disco = new DiscoRegistro(direccion);
		// Creacion para la base de datos

		String url = "jdbc:mysql://localhost:3306/objetos2";
		String user = "root";
		String pass = "";
		BaseDeDatosRegistro baseDeDatos = new BaseDeDatosRegistro(url, user, pass);

		Concurso java = new Concurso("java", 1234, LocalDate.now(), duracionDelCurso, baseDeDatos);
		java.inscribirParticipante(new Participante("Juan", 52));
		java.inscribirParticipante(new Participante("Jonathan", 39));
		assertEquals(true, java.estaInscripto("Juan"));

	}

//	@Test
//	void testInscribirParticipanteEnTermino() {
//
//		int duracionDelCurso = 10;
//		LocalDate fecha = LocalDate.now().plusDays(-2);
//		Concurso java = new Concurso("java", 5, 1234, fecha, duracionDelCurso);
//		Participante juan = new Participante("Juan", 18493526);
//		java.inscribirParticipante(juan);
//		assertEquals(0, juan.getPuntaje());
//		assertEquals(true, java.estaInscripto(juan));
//
//	}
//
//	@Test
//	void testInscribirParticipanteFueraDeTermino() {
//		int duracionDelCurso = 5;
//		LocalDate fecha = LocalDate.now().plusDays(7);
//		Concurso java = new Concurso("java", 5, 1234, fecha, duracionDelCurso);
//		Participante juan = new Participante("Juan", 18493526);
//		java.inscribirParticipante(juan);
//		assertEquals(false, java.estaInscripto(juan));// Crear metodo que verifique la inscripcion
//		assertEquals(0, juan.getPuntaje());
//
//	}

}
