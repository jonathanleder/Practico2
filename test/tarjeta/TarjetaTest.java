package tarjeta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tarjetas.Bebida;
import tarjetas.DispositivoElectronico;
import tarjetas.Pedido;
import tarjetas.Plato;
import tarjetas.TarjetaComarcaPlus;

class TarjetaTest {

	@Test
	void testTarjetaComarcaPlus() {
		double valorEsperado = 824;// 824 es el costo total 26
		Plato ravioles = new Plato("Ravioles con tuco", 500);
		Bebida gaseosa = new Bebida("Fanta", 300);
		String direccion = "C:\\\\\\\\Users\\\\\\\\jonyl\\\\\\\\Desktop\\\\\\\\registro_ventas.txt";
		Pedido miPedido = new Pedido(ravioles, gaseosa);
		TarjetaComarcaPlus comarca = new TarjetaComarcaPlus("Jonathan Leder", 456123789, 850);

		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido, direccion);
		assertEquals(valorEsperado, miDispositivo.calcularCostoTotal(comarca, 5));
	}

//	@Test
//	void testTarjetaMasterCard() {
//		double valorEsperado = 1448;// 1448 es el costo total
//		Plato ravioles = new Plato("Ravioles con tuco", 500);
//		Plato pescado = new Plato("Pescado", 600);
//		Bebida gaseosa = new Bebida("Fanta", 300);
//		Pedido miPedido = new Pedido(ravioles, gaseosa);
//		miPedido.agregarPlato(pescado);
//		TarjetaMastercard master = new TarjetaMastercard("Jonathan Leder", 456123789, 2000);
//
//		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido);
//		assertEquals(valorEsperado, miDispositivo.calcularCostoTotal(master, 5));
//	}
//
//	@Test
//	void testTarjetaVisa() {
//		double valorEsperado = 831;// 831 es el costo total
//		Plato ravioles = new Plato("Ravioles con tuco", 500);
//		Bebida gaseosa = new Bebida("Fanta", 300);
//		Pedido miPedido = new Pedido(ravioles, gaseosa);
//		TarjetaVisa visa = new TarjetaVisa("Jonathan Leder", 456123789, 850);
//
//		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido);
//		assertEquals(valorEsperado, miDispositivo.calcularCostoTotal(visa, 5));
//	}
//
//	@Test
//	void testTarjetaViedma() {
//		double valorEsperado = 840;// 840 es el costo total
//		Plato ravioles = new Plato("Ravioles con tuco", 500);
//		Bebida gaseosa = new Bebida("Fanta", 300);
//		Pedido miPedido = new Pedido(ravioles, gaseosa);
//		TarjetaViedma viedma = new TarjetaViedma("Jonathan Leder", 456123789, 850);
//		DispositivoElectronico miDispositivo = new DispositivoElectronico(miPedido);
//		assertEquals(valorEsperado, miDispositivo.calcularCostoTotal(viedma, 5));
//	}

}
