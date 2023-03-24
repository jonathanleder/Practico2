package tarjetas;

public class TarjetaVisa extends Tarjeta {

	public TarjetaVisa(String titular, int numeroTarjeta, double saldo) {
		super(titular, numeroTarjeta, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pagar(double importeTotal) {
		this.saldo -= importeTotal;
	}

	@Override
	public double calcularDescuento(double bebida, double plato) {
		return bebida * 0.03;// 3% sobre la bebida
	}

}
