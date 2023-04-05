package concurso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import interfaces.Notificacion;
import interfaces.Registro;
import persistance.BaseDeDatosRegistro;
import persistance.DiscoRegistro;

class ConcursoTest {

	@Test
	void testInscribirParticipantePrimerDia() {

		int duracionDelCurso = 10;

		// Creacion para almacenamiento local
		DiscoRegistro disco = new DiscoRegistro("C:\\\\Users\\\\jonyl\\\\Desktop\\\\registro_participantes.txt");

		// Creacion para la base de datos
		BaseDeDatosRegistro baseDeDatos = new BaseDeDatosRegistro("jdbc:mysql://localhost:3306/objetos2", "root", "");

		// Creacion del fakeRegistro
		Registro registroFake = new FakeRegistro();
		// Creacion de fakeNotificacion
		Notificacion emailFake = new FakeEmail("inscripcioaconcursos@example.com", "Inscripcion al concurso elegido ",
				"su solicitud fue aprobada");
		boolean notificacionEnviada = emailFake.enviarNotificacion();

		// Implementacion
		Concurso java = new Concurso("java", 1234, LocalDate.now(), duracionDelCurso, registroFake, emailFake);
		java.inscribirParticipante(new Participante("Juan", 52));
		java.inscribirParticipante(new Participante("Jonathan", 39));
		assertEquals(true, java.estaInscripto("Juan"));
		assertEquals(true, emailFake.seNotifico());

	}
//Para simular los otros tipos de inscripcion solo hay que cambiar la fecha que se pasa por parametro

}
