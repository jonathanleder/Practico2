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
		String direccion = "C:\\\\Users\\\\jonyl\\\\Desktop\\\\registro_participantes.txt";
		DiscoRegistro disco = new DiscoRegistro(direccion);

		// Creacion para la base de datos
		String url = "jdbc:mysql://localhost:3306/objetos2";
		String user = "root";
		String pass = "";
		BaseDeDatosRegistro baseDeDatos = new BaseDeDatosRegistro(url, user, pass);

		// Creacion del fakeMail
		Notificacion notificacion = new FakeEmail();
		boolean notificacionEnviada = notificacion.enviarNotificacion();

		// Creacion del fakeRegistro
		Registro registroFake = new FakeRegistro();
		// Creacion de fakeNotificacion
		Notificacion emailFake = new FakeEmail();

		// Implementacion
		Concurso java = new Concurso("java", 1234, LocalDate.now(), duracionDelCurso, registroFake, emailFake);
		java.inscribirParticipante(new Participante("Juan", 52));
		java.inscribirParticipante(new Participante("Jonathan", 39));
		assertEquals(true, java.estaInscripto("Juan"));
		assertEquals(true, emailFake.seNotifico());

	}
//Para simular los otros tipos de inscripcion solo hay que cambiar la fecha que se pasa por parametro

}
