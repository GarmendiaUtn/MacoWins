import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NegocioTest {

	@Test
	public void testCreacionInstancia() {
		Negocio unNegocio = new Negocio(10.0);
		// Assert.assertTrue(unNegocio.prendas().size() == 0);
		Assert.assertTrue(unNegocio.valorFijo() == 10);
		// Assert.assertTrue(unNegocio.ventas().size() == 0);
	}

	@Test
	public void testValorDeUnaPrendaInternacional() {
		TipoPrenda unTipoPrenda = new TipoPrenda("Camisa", 10);
		Internacional unaPrenda = new Internacional(unTipoPrenda);
		Negocio unNegocio = new Negocio(20.0, unaPrenda);
		Assert.assertTrue((unNegocio.precioPara(unaPrenda)) == ((20 + 10) * 1.3));
	}

	@Test
	public void testValorDeUnaPrendaNacional() {
		TipoPrenda unTipoPrenda = new TipoPrenda("Camisa", 10);
		Nacional unaPrenda = new Nacional(unTipoPrenda);
		Negocio unNegocio = new Negocio(20.0, unaPrenda);
		Assert.assertTrue((unNegocio.precioPara(unaPrenda)) == (20 + 10));
	}

	@Test
	public void testTotalVentaAUnaFecha() {
		TipoPrenda unTipoPrendaCamisa = new TipoPrenda("Camisa", 10);
		Internacional unaPrendaInternacional = new Internacional(unTipoPrendaCamisa);
		TipoPrenda unTipoPrendaPantalon = new TipoPrenda("Pantalon", 15);
		Nacional unaPrendaNacional = new Nacional(unTipoPrendaPantalon);
		Venta unaVentaPantalon = new Venta(unaPrendaNacional, 5, "12/12/2015");
		Venta unaVentaCamisa = new Venta(unaPrendaInternacional, 3, "12/12/2015");
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(unaPrendaNacional);
		prendas.add(unaPrendaInternacional);
		List<Venta> ventas = new ArrayList<Venta>();
		ventas.add(unaVentaCamisa);
		ventas.add(unaVentaPantalon);
		Negocio unNegocio = new Negocio(20.0, prendas, ventas);
		Assert.assertTrue((unNegocio.totalVendidoEn("12/12/2015")) == (((20 + 10) * 1.3 * 3) + ((20 + 15) * 5)));
	}

	@Test
	public void testTotalVentaAUnaFechaTeniendoOtraFecha() {
		TipoPrenda unTipoPrendaCamisa = new TipoPrenda("Camisa", 10);
		Internacional unaPrendaInternacional = new Internacional(unTipoPrendaCamisa);
		TipoPrenda unTipoPrendaPantalon = new TipoPrenda("Pantalon", 15);
		Nacional unaPrendaNacional = new Nacional(unTipoPrendaPantalon);
		Venta unaVentaPantalon = new Venta(unaPrendaNacional, 5, "12/12/2015");
		Venta unaVentaCamisa = new Venta(unaPrendaInternacional, 3, "13/12/2015");
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(unaPrendaNacional);
		prendas.add(unaPrendaInternacional);
		List<Venta> ventas = new ArrayList<Venta>();
		ventas.add(unaVentaCamisa);
		ventas.add(unaVentaPantalon);
		Negocio unNegocio = new Negocio(20.0, prendas, ventas);
		Assert.assertTrue((unNegocio.totalVendidoEn("12/12/2015")) == (((20 + 15) * 5)));
	}
	
	@Test
	public void testTotalVentaSinOperacionesALaFecha() {
		TipoPrenda unTipoPrendaCamisa = new TipoPrenda("Camisa", 10);
		Internacional unaPrendaInternacional = new Internacional(unTipoPrendaCamisa);
		TipoPrenda unTipoPrendaPantalon = new TipoPrenda("Pantalon", 15);
		Nacional unaPrendaNacional = new Nacional(unTipoPrendaPantalon);
		Venta unaVentaPantalon = new Venta(unaPrendaNacional, 5, "12/12/2015");
		Venta unaVentaCamisa = new Venta(unaPrendaInternacional, 3, "13/12/2015");
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(unaPrendaNacional);
		prendas.add(unaPrendaInternacional);
		List<Venta> ventas = new ArrayList<Venta>();
		ventas.add(unaVentaCamisa);
		ventas.add(unaVentaPantalon);
		Negocio unNegocio = new Negocio(20.0, prendas, ventas);
		Assert.assertTrue((unNegocio.totalVendidoEn("11/12/2015")) == 0);
	}
}