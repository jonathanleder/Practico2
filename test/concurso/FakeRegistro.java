package concurso;

import interfaces.Registro;

public class FakeRegistro implements Registro {

	boolean registrado;

	public FakeRegistro() {// Mismo caso que en el mail, corregir
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean registrarParticipante(Participante inscripto, Concurso concurso) {

		return registrado = true;

	}

	@Override
	public boolean registrarVenta(double importe) {
		return registrado = true;
	}

	public boolean estaInscripto(String nombreParticipante) {
		return registrado;
	}

}
