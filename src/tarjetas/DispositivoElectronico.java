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
		double descuento = unaTarjeta.calcularDescuento(pedido.importeBebida(), pedido.importePlato());
		disco.registrarVenta(pedido.importeTotal() + pedido.calcularPropina(propina) - descuento);
		return pedido.importeTotal() + pedido.calcularPropina(propina) - descuento;
	}

}
