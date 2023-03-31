package tarjetas;

import interfaces.Registro;

public class DispositivoElectronico {

	private Pedido pedido;
	private Registro registro;

	public DispositivoElectronico(Pedido unPedido, Registro ruta) {
		this.pedido = unPedido;
		this.registro = ruta;
	}

	public double calcularCostoTotal(Tarjeta unaTarjeta, double propina) {
		registro.registrarVenta(pedido.importeTotal() + pedido.calcularPropina(propina) - descuento(unaTarjeta));
		return pedido.importeTotal() + pedido.calcularPropina(propina) - descuento(unaTarjeta);
	}

	private double descuento(Tarjeta unaTarjeta) {
		return unaTarjeta.calcularDescuento(pedido.importeBebida(), pedido.importePlato());
	}

}
