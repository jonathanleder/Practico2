package concurso;

import interfaces.Registro;

public class FakeRegistro implements Registro {

	public FakeRegistro() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean registrarParticipante(Participante inscripto, Concurso concurso) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public boolean registrarVenta(double importe) {
		// TODO Auto-generated method stub
		return true;
	}

}
