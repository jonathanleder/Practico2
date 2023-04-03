package concurso;

import interfaces.Notificacion;

public class FakeEmail implements Notificacion {

	public FakeEmail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean enviarNotificacion() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean seNotifico() {
		// TODO Auto-generated method stub
		return true;
	}

}
