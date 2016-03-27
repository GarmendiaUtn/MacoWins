
public class Venta {

	private Prenda prenda;
	private int cantidad;
	private String fecha;

	public Venta(Prenda unaPrenda, int unaCantidad, String unaFecha) {
		prenda = unaPrenda;
		cantidad = unaCantidad;
		fecha = unaFecha;
	}

	public Prenda prenda() {
		return prenda;
	}

	public int cantidad() {
		return cantidad;
	}

	public String fecha() {
		return fecha;
	}

	public Double totalCon(Double unValorFijo) {
		return this.prenda().precioCon(unValorFijo) * this.cantidad();
	}
}
