package tarjetas;

public class TarjetaViedma extends Tarjeta {

	public TarjetaViedma(String titular, int numeroTarjeta, float saldo) {
		super(titular, numeroTarjeta, saldo);
	}

	@Override
	public void pagar(double importeTotal) {
		this.saldo -= importeTotal;
	}

	@Override
	public double calcularDescuento(double bebida, double plato) {
		return 0;
	}

}
