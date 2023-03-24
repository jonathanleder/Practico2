package tarjetas;

public class TarjetaMastercard extends Tarjeta {

	public TarjetaMastercard(String titular, int numeroTarjeta, double saldo) {
		super(titular, numeroTarjeta, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pagar(double importeTotal) {
		this.saldo -= importeTotal;
	}

	@Override
	public double calcularDescuento(double bebidas, double platos) {
		return platos * 0.02;// 2% sobre los platos

	}

}
