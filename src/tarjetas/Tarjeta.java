package tarjetas;

public abstract class Tarjeta {

	private int numTarjeta;
	private String titular;
	protected double saldo;

	public Tarjeta(String titular, int numeroTarjeta, double saldo) {

		this.titular = titular;
		this.numTarjeta = numeroTarjeta;
		this.saldo = saldo;
	}

	public abstract void pagar(double importeTotal);// Ingresar el porcentaje por parametro genera
													// acoplamiento??

	public abstract double calcularDescuento(double bebidas, double platos);

	public double saldoDisponible() {
		return this.saldo;
	}

}
