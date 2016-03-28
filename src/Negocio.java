import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Negocio {

	private Double valorFijo;
	List<Venta> ventas = new ArrayList<Venta>();

	public Negocio(Double unValorFijo) {
		valorFijo = unValorFijo;
	}

	public Negocio(Double unValorFijo, List<Venta> unasVentas) {
		valorFijo = unValorFijo;
		ventas.addAll(unasVentas);
	}

	public Double valorFijo() {
		return valorFijo;
	}

	public Double precioPara(Prenda unaPrenda) {
		return unaPrenda.precioCon(this.valorFijo());
	}

	public Double totalVendidoEn(String unaFecha) {
		Double total = 0.0;
		Iterator<Venta> itr = ventas.iterator();
		while (itr.hasNext()) {
			Venta venta = itr.next();
			if (venta.fecha() == unaFecha) {
				total += venta.totalCon(this.valorFijo());
			}
		}
		return total;
	}
}
