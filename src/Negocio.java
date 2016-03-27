import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Negocio {

		private Double valorFijo;
		List<Prenda> prendas = new ArrayList<Prenda>();
		List<Venta> ventas = new ArrayList<Venta>();
		public Negocio(Double unValorFijo){
			valorFijo = unValorFijo;	
		}
		public Negocio(Double unValorFijo, Prenda unaPrenda){
			valorFijo = unValorFijo;	
			prendas.add(unaPrenda);
		}
		public Negocio(Double unValorFijo, List<Prenda> unasPrendas, List<Venta> unasVentas){
			valorFijo = unValorFijo;	
			prendas.addAll(unasPrendas);
			ventas.addAll(unasVentas);
		}
		public Double valorFijo(){
			return valorFijo;
		}
	
		public Double precioPara(Prenda unaPrenda) 
		{
			return unaPrenda.precioCon(this.valorFijo()); 
		}
		public Double totalVendidoEn(String unaFecha){
			Double total=0.0;
			Iterator<Venta> itr = ventas.iterator();
		     while(itr.hasNext()) {
		         Venta venta = itr.next();
		         total += venta.totalCon(this.valorFijo()); 
		     }
			return total;
		}
}
