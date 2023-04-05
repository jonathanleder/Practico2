package concurso;

import interfaces.Notificacion;

public class FakeEmail implements Notificacion {

	private String destinatario;
	private String asunto;
	private String mensaje;

	boolean notificado;

	public FakeEmail(String destinatario, String asunto, String mensaje) {// Agregar variable de instancia para despues
																			// corroborar el envio

		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.notificado = false;
	}

	@Override
	public boolean enviarNotificacion() {

		return this.notificado = true;
	}

	@Override
	public boolean seNotifico() {
		// TODO Auto-generated method stub
		return notificado;
	}

}
