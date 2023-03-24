package tarjetas;

public class Plato {

	private String nombre;
	private double precio;

	public Plato(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public double importe() {
		return this.precio;
	}

	public String detallePlato() {
		return "Precio:" + String.valueOf(precio) + " Nombre:" + this.nombre;
	}
}
