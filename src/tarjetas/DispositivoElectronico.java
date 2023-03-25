package tarjetas;

import persistance.DiscoRegistro;

public class DispositivoElectronico {

	private Pedido pedido;
	private DiscoRegistro disco;

	public DispositivoElectronico(Pedido unPedido, String ruta) {
		this.pedido = unPedido;
		this.disco = new DiscoRegistro(ruta);
	}

	public double calcularCostoTotal(Tarjeta unaTarjeta, double propina) {
		return disco.registrarVenta(pedido.importeTotal() + pedido.calcularPropina(propina) - descuento(unaTarjeta));
	}

	private double descuento(Tarjeta unaTarjeta) {
		return unaTarjeta.calcularDescuento(pedido.importeBebida(), pedido.importePlato());
	}

}
