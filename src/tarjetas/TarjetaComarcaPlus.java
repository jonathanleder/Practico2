package tarjetas;

public class TarjetaComarcaPlus extends Tarjeta {

	public TarjetaComarcaPlus(String titular, int numeroTarjeta, float saldo) {
		super(titular, numeroTarjeta, saldo);
	}

	@Override
	public void pagar(double importeTotal) {
		// TODO Auto-generated method stub

		this.saldo -= importeTotal;
	}

	@Override
	public double calcularDescuento(double bebidas, double platos) {// Ingresan dos double por
																	// parametros(bebidas,platos)
		return (bebidas + platos) * 0.02;// 2% al total

	}

}
