package tarjetas;

public class Bebida {
	private String nombre;
	private float precio;

	public Bebida(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public float importe() {
		return this.precio;
	}

	public String detalleBebida() {
		return "Precio:" + String.valueOf(precio) + " Nombre:" + this.nombre;
	}

}
